package com.ect888.bus.impl;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ect888.bus.Util;
import com.ect888.bus.Worker;
import com.ect888.bus.view.impl.InputRowData;
import com.ect888.service.impl.TblVbaonlTransServiceImpl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 独立线程发起外部调用。
 * 
 * 针对sit自动验证小程序
 * 
 * 根据入参发起请求，得到结果，拼装输出
 * 
 * @author fanyj
 *
 */
@Slf4j
@Component
@Scope("prototype")
@Setter
public class WorkerImpl4Test implements Worker{

	private BlockingQueue<List<String>> blockingQueue;

	private InputRowData inputRowData;
	
	@Override
	public boolean produce(List<String> result) {
		boolean flag=false;
		try {
			do {
				flag = blockingQueue.offer(result,200,TimeUnit.MILLISECONDS);
			}while(!flag);
		} catch (InterruptedException e) {
			log.error("",e);
		}
		return true;
	}

	@Override
	public void setBlockingQueue(BlockingQueue<List<String>> blockQueue) {
		this.blockingQueue=blockQueue;
	}
	
	private String seq;
	
	@Override
	public void run() {
		try {
			doWork(seq);
		}catch(RuntimeException e) {
			log.error(seq+"处理出现运行时错误",e);
		}
	}
	
	/**
	 * @param seq 唯一编号
	 */
	private void doWork(String seq) {
		
		log.info(seq+" worker start...," + inputRowData);
		ChangelessOutput resp= null;
		
		String isOnePlusNStr=inputRowData.getCaseDes().get(Util.IS_ONE_PLUS_N_STR);
		log.info(seq+"IS_ONE_PLUS_N_STR为"+isOnePlusNStr);
		if(null!=isOnePlusNStr)
			isOnePlusNStr=isOnePlusNStr.trim();
		
		boolean onePlusN="true".equalsIgnoreCase(isOnePlusNStr);
		
		log.info(seq+"是否调用N次102结果查询onePlusN为"+onePlusN);
		
		if(!onePlusN) {
			resp=functionCommonImpl.invoke(inputRowData.getPtyKey(),inputRowData.getParams());
		}else {
			resp=functionCommonOnePlusNImpl.invoke(inputRowData.getPtyKey(),inputRowData.getParams());
		}
		
		Map<String, String> expectedRespMap=new HashMap<>();
		Map<String, String> expectedDbMap=new HashMap<>();
				
		inputRowData.getExpected().forEach((k,v)->{
			if(k.startsWith(Util.DB_EXPECTED_HEAD)) {
				expectedDbMap.put(k, v);
			}else if(k.startsWith(Util.EXPECTED_HEAD)){
				expectedRespMap.put(k, v);
			}else {
				log.error(seq+" k="+k+",v="+v+", while just support head with "+Util.DB_EXPECTED_HEAD+" and "+Util.EXPECTED_HEAD);
			}
		});
		
		Map<String,String> assertRespMap=assertRespResult.produceAssertResult(expectedRespMap, resp);
		Map<String,String> assertMap=assertRespMap;
		
		DbOutput db=null;
		String sysSeqNb=resp.getSysseqnb();
		if(!expectedDbMap.isEmpty()) {
			db=new DbOutput();
			fillDb(expectedDbMap, sysSeqNb, assertMap, db);
		}
		
		List<String> result=produceResult(assertMap, resp, inputRowData,db,resp.getConsumingTime());
		
		produce(result);

		log.info(seq+" worker completed,"+ inputRowData);
	}
	
	/**
	 * @param expectedDbMap
	 * @param sysSeqNb
	 * @param assertMap
	 * @param db
	 */
	private void fillDb(Map<String, String> expectedDbMap,String sysSeqNb,Map<String,String> assertMap,	DbOutput db) {
		
		String dbJsonResult=service.getBySysSeqNb(sysSeqNb);
		if(null==dbJsonResult) {
			log.error(seq+","+sysSeqNb+" has no db record!");
			return;
		}
		
		db.setDbJsonResult(dbJsonResult);
		
		JSONObject common=JSON.parseObject(dbJsonResult);//外层
		String cretmStr=common.getString(Util.DB_CRETM_STR);
		String updatetmStr=common.getString(Util.DB_UPDATETM_STR);
		
		String formatPattern="yyyy-MM-dd'T'HH:mm:ss.SSS";//(用T分隔年月日和时分秒)
		DateTimeFormatter df = DateTimeFormatter.ofPattern(formatPattern);
		
		try {
			LocalDateTime cretm = LocalDateTime.parse(cretmStr, df);
			LocalDateTime updatetm = LocalDateTime.parse(updatetmStr, df);
			
			db.setCretm(cretm);
			db.setUpdatetm(updatetm);
			
			ZoneOffset zoneOffset=OffsetDateTime.now().getOffset();
			long timeDiffMills=updatetm.toInstant(zoneOffset).toEpochMilli()
					-cretm.toInstant(zoneOffset).toEpochMilli();
			db.setTimeDiffMills(timeDiffMills);//时差，单位毫秒：流水更新时间-流水创建时间
		}catch(DateTimeParseException e) {
			log.error(seq+","+sysSeqNb+"时间转换出错formatPattern="+formatPattern+","+cretmStr+","+updatetmStr,e);
		}
		
		Map<String,String> assertDbMap=assertDbResultImpl.produceAssertResult(expectedDbMap, db);
		if(null!=assertDbMap)
			assertMap.putAll(assertDbMap);
	}
	
	@Autowired
	private TblVbaonlTransServiceImpl service;
	
	@Autowired
	private AssertDbResultImpl assertDbResultImpl;
	
	@Autowired
	private AssertRespResultImpl assertRespResult;
	
	@Autowired
	private FunctionCommonImpl functionCommonImpl;
	
	@Autowired
	private FunctionCommonOnePlusNImpl functionCommonOnePlusNImpl;
	
	/**
	 * 
	 * 输出数据和输出title对应排列
	 * 按照title种类顺序排列：
	 * 断言结果（和期望值相对应）				固定输出	数据库流水 耗时情况	案例说明		会话秘钥	业务请求入参	期望值入参		
	 * 
	 * assert_error_no	assert_status	assert_respcd	assert_respinfo	db_assert_mPSSim	db_assert_respCd	db_assert_respInfo	sysseqnb	results	交易耗时（毫秒）	交易响应时间	交易发起时间	数据库字段结果的json格式	数据库流水时差（毫秒）	数据库结束时间	数据库开始时间	caseNo	case_desc	ptyKey	funcNo	toSign_ptyacct	toSign_ptycd	toPicBase64_videopic	usernm	toAes_toUrl_toBase64_certseq	toSign_biztyp	toSign_biztypdesc	toSign_placeid	toSign_timestamp	toSign_sourcechnl	expected_error_no	expected_status	expected_respcd	expected_respinfo	db_expected_mPSSim	db_expected_respCd	db_expected_respInfo
	 * 
	 * 
	 * @param assertMap 断言结果（true或者false，其中false的标红，和期望值相对应）
	 * @param resp 固定输出，即VBA响应结果
	 * @param inputRowData 输入数据，包括title种类案例说明		会话秘钥	业务请求入参	期望值入参	
	 * @param db 数据库查询出的流水记录，包括（更新时间-创建时间）时间差
	 * @param ct 交易时间，包括（收到交易返回结果时间-交易发起时间）时间差
	 * @return 输出数据和输出title对应排列后的结果数据
	 * 
	 */
	private List<String> produceResult(Map<String,String> assertMap,ChangelessOutput resp,InputRowData inputRowData,DbOutput db,ConsumingTime ct) {
		
		List<String> result=new ArrayList<String>();
		
		/**
		 * 输出title和行号一一对应关系
		 */
		List<String> outPutTitle=inputRowData.getOutPutTitle();
		
		int start=0;
		
		if(null!=assertMap) {
			IntStream.range(start,start+inputRowData.getExpected().size()).forEach(i->{
				String k=outPutTitle.get(i);
				
				result.add(assertMap.get(k));
			});
		}else {
			//占位
			IntStream.range(start,start+inputRowData.getExpected().size()).forEach(i->{
				result.add("");				
			});
		}
		start=start+inputRowData.getExpected().size();
		
		if(null!=resp) {
			result.addAll(resp.dataList());
		}else {
			//占位
			IntStream.range(start,start+ChangelessOutput.TITLE_LIST.size()).forEach(i->{
				result.add("");				
			});
		}
		start=start+ChangelessOutput.TITLE_LIST.size();
		
		
		if(null!=ct) {
			result.addAll(ct.dataList());
		}else {
			//占位
			IntStream.range(start,start+ConsumingTime.TITLE_LIST.size()).forEach(i->{
				result.add("");				
			});
		}
		start=start+ConsumingTime.TITLE_LIST.size();
		
		if(null!=db) {
			result.addAll(db.dataList());
		}else {
			//占位
			IntStream.range(start,start+DbOutput.TITLE_LIST.size()).forEach(i->{
				result.add("");				
			});;
		}
		start=start+DbOutput.TITLE_LIST.size();
		
		if(null!=inputRowData) {
			//案例说明		
			IntStream.range(start,start+inputRowData.getCaseDes().size()).forEach(i->{
				String k=outPutTitle.get(i);
				
				result.add(inputRowData.getCaseDes().get(k));
			});
			start=start+inputRowData.getCaseDes().size();
			
			//会话秘钥	
			IntStream.range(start,start+1).forEach(i->{
				result.add(inputRowData.getPtyKey());
			});
			start=start+1;
			
			//业务请求入参	
			IntStream.range(start,start+inputRowData.getParams().size()).forEach(i->{
				String k=outPutTitle.get(i);
				
				result.add(inputRowData.getParams().get(k));
			});
			start=start+inputRowData.getParams().size();
			
			//期望值入参	
			IntStream.range(start,start+inputRowData.getExpected().size()).forEach(i->{
				String k=outPutTitle.get(i);
				
				result.add(inputRowData.getExpected().get(k));
			});
		}
		
		return result;
	}


}
