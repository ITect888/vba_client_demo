package com.ect888.bus.view.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.OrgUtil;
import com.ect888.bus.Util;
import com.ect888.bus.impl.ChangelessOutput;
import com.ect888.bus.view.CallBack;
import com.ect888.config.TitleTransConfig;
import com.ect888.controller.Controller;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 从机构跑批入参_模板Excel文件读取数据处理
 * 模板为：
 *  A 第一行为中文title,非合并单元格
 *  
 *  B 第二行开始为数据,非合并单元格
 * 
 * 
 * 不是线程安全的
 * 
 * @author fanyj
 *
 */
@Component
@Slf4j
public class CallBack4Org implements CallBack {
	
	private Controller controller;
	
	/**
	 * 多个多行标题
	 */
	private List<List<String>> outPutTitles;
	
	/**
	 * 字段title列号和字段title值映射
	 * 非合并单元格
	 */
	private Map<Integer,String> titleMap; 
	
	@Override
	public void process(int rowNum,Collection<MyInputExcelRowColData> row) {
		if(0>=rowNum) {//A 第一行为中文title
			titleMap=processTitleRow(row);
			return;
		}
		
		outPutTitles=produceOutPutTitle();
		
		//B 第二行开始为数据 数据的处理
		InputRowData inputRowData=processDataRow(titleMap,row);
		
		//设置输出title和列号一一对应关系映射数组，其中数组下标为列号，数组值为输出title
		inputRowData.setOutPutTitle(outPutTitles.get(0));
		
		controller.invoke(inputRowData);
	}
	
	/**
	 * 产生字段title列号和字段title值映射
	 * 
	 * @param row
	 * @return
	 */
	private Map<Integer, String> processTitleRow(Collection<MyInputExcelRowColData> row) {
		
		Map<Integer,String> titleMap=new HashMap<>();//字段title列号和字段title值映射
		
		row.forEach(d->{
			String chi=d.getValue();//字段中文title
			int k=d.getColStartIndexIncluded();//字段title列号
			String f=orgUtil.getChi2fieldMap().get(chi);//中文title到字段英文名映射
			
			titleMap.put(k, f);
			
		});
		
		return titleMap;
	}
	
	@Autowired
	private OrgUtil orgUtil;

	/**
	 * 
	 * 生产输出Excel的title，输出title按照种类分，顺序为：
	 * 指定提取的输出（由application.yml resp-extract.field2chi-list配置）  固定输出（sysseqnb	results） 输入中文title	
	 * 
	 * @return
	 */
	private List<List<String>> produceOutPutTitle(){
		
		List<List<String>> outPutTitles=new ArrayList<>();
		
		ArrayList<String> outPutTitle=new ArrayList<>();
		
		orgUtil.getField2chiMap().forEach((f,c)->{
			outPutTitle.add(c);
		});
		
		outPutTitle.addAll(ChangelessOutput.TITLE_LIST);
		
		List<String> chiTitlesList=new ArrayList<>();//中文title
		
		titleTransConfig.getChi2fieldList().forEach(d->{
			chiTitlesList.add(d.getChi());
		});
		
		outPutTitle.addAll(chiTitlesList);
		
		outPutTitles.add(outPutTitle);
		
		log.info("outPutTitles="+JSON.toJSONString(outPutTitles));
		
		return outPutTitles;
	}
	
	
	/**
	 * 
	 * 其他行为数据行row的逐行处理
	 * 
	 * 根据titleMap生成：
	 * 字段名到字段值的映射，会话秘钥
	 * 字段名到字段值的映射，业务请求入参
	 * 
	 * 
	 * titleMap是title列号和title值映射
	 * 
	 * @param titleMap title列号和title值映射
	 * @param row 数据行
	 * @return
	 */
	private InputRowData processDataRow(Map<Integer,String> titleMap,Collection<MyInputExcelRowColData> row){
		
		log.info("其他行为数据行的逐行处理...");
		
		//字段名到字段值的映射，业务请求入参
		Map<String,String> params=new HashMap<String,String>();
		
		//接口必填字段输入参数中， 机构跑批入参_模板没有，取固定值的字段
		titleTransConfig.getFieldOmitList().forEach(f->{
			params.put(f.getField(),f.getChi());
		});
				
		// 机构跑批入参_模板输入填入
		row.forEach(
				t->{
					//数据对应的字段title
					String title=titleMap.get(t.getColStartIndexIncluded());//字段名
					
					params.put(title,t.getValue());
					
				}
		);
		
		// 会忽略空单元格，因此，主动补齐
		titleMap.forEach((k,v)->{
			if(!params.containsKey(v))//接口请求入参params没有此字段,填充补齐空字符串
				params.put(v, "");
		});
		
		//功能号funcNo
		params.put(Util.FUNC_NO_STR, titleTransConfig.getFuncNo());
		
		//机构编号
		params.put(Util.TO_SIGN_PTY_CD, titleTransConfig.getPtycd());
		
		//机构账号
		params.put(Util.TO_SIGN_PTY_ACCT, titleTransConfig.getPtyacct());
		
		InputRowData inputRowData=new InputRowData();
		inputRowData.setParams(params);
		
		String ptyKey=titleTransConfig.getPtyKey();
		inputRowData.setPtyKey(ptyKey);

		log.info("其他行为数据行的逐行处理完成,inputRowData="+JSON.toJSONString(inputRowData));
		
		return inputRowData;

	}
	
	@Autowired
	private TitleTransConfig titleTransConfig;
	
	@Override
	public List<List<String>> getOutPutTitle() {
		return outPutTitles;
	}


	@Override
	public void setController(Controller controller) {
		this.controller=controller;
	}
	
}
