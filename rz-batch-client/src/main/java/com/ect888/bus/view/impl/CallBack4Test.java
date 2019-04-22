package com.ect888.bus.view.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.Util;
import com.ect888.bus.impl.ChangelessOutput;
import com.ect888.bus.impl.ConsumingTime;
import com.ect888.bus.impl.DbOutput;
import com.ect888.bus.view.CallBack;
import com.ect888.controller.Controller;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 从自动验证小程序入参_模板Excel文件读取数据处理
 * 模板为：
 * A 第一行title为，是输入数据分类，包括:
 * 案例说明:其下的所有列只供人查阅，程序并不使用	
 * 会话秘钥:必须有	
 * 业务请求入参:其下的所有列，根据不同服务，入参数目不一，都遵循：
 * 一业务请求入参title规则：
 * 1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
 * 2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
 * 3 toPicBase64__开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
 * 4 toUrl_toBase64_开头：字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数
 * 5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
 * 
 * 二：业务请求入参值规则：
 * 1 spec_则是默认固定值:SPEC_MAP有则使用，否则为0
 * 2 spec_time是程序自动取当前时间
 * 3 否则，填写什么值就使用什么值
 * 
 * 期望值入参：
 * 其下的所有列表示期望得到的返回结果，用于获得断言输出。期望值入参的title和断言输出的title一一对应，除了开通，前者是expected_后者是assert_，其他都一模一样。
 * 				
 * 这些类型可以是合并多列的单元格；连续多列属于同一合并单元格，这些列数据就属于这个单元格文字描述的类型
 * 
 * B 第二行title为输入数据字段名，大小写敏感，无合并单元格：
 * 需要对应VBA接口文档的输入字段名，
 * 根据是否参加签名，是否aes加密再url编码再base64编码形式post，是否文件路径读入图片base64编码后的字符串post，
 * 相应的添加toSign_开头，oAes_toUrl_toBase64_开头，toPicBase64__开头
 * 
 * 如
 *  caseNo	case_desc	ptyKey	funcNo	toSign_ptyacct	toSign_ptycd	toPicBase64_videopic	usernm	toAes_toUrl_toBase64_certseq	toSign_biztyp	toSign_biztypdesc	toSign_placeid	toSign_timestamp	toSign_sourcechnl	expected_error_no	expected_status	expected_respcd	expected_respinfo	db_expected_mPSSim	db_expected_respCd	db_expected_respInfo
 *   
 * C 其他行为数据行：
 * 1 spec_则是默认固定值:SPEC_MAP有则使用，否则为0
 * 2 spec_time是程序自动取当前时间
 * 3 否则，填写什么值就使用什么值
 * 
 * 
 * 不是线程安全的
 * 
 * @author fanyj
 *
 */
@Component
@Slf4j
public class CallBack4Test implements CallBack {
	
	private Controller controller;
	
	/**
	 * 第一行title类别的读入处理结果
	 * 
	 * 包括三部分：
	 * 1 期望值入参的合并单元格信息；
	 * 2 除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属数组映射；数组下表代表此title类别占有的列号，数组值代表合并单元格信息（尤其包括title类别）
	 * 3 最后一个合并单元格信息
	 */
	private TypeRowMap typeRowMap;
	
	/**
	 * 多个多行标题
	 */
	private List<List<String>> outPutTitles;
	
	/**
	 * title列号和title值映射
	 * 即，主键为MyInputExcelRowColData的 getColStartIndexIncluded（即title列号），值为MyInputExcelRowColData的getValue（即title值）
	 */
	private Map<Integer,String> titleMap; 
	
	@Override
	public void process(int rowNum,Collection<MyInputExcelRowColData> row) {
		if(0>=rowNum) {
			typeRowMap=processTypeRow(row);
			return;
		}
		
		if(1==rowNum) {
			titleMap=processTitleRow(row);
			outPutTitles=produceOutPutTitle(titleMap, typeRowMap.getExpected());
			return;
		}
		
		//数据的处理
		InputRowData inputRowData=processDataRow(titleMap,typeRowMap,row);
		//设置输出title和列号一一对应关系映射数组，其中数组下标为列号，数组值为输出title
		inputRowData.setOutPutTitle(outPutTitles.get(0));
		
		controller.invoke(inputRowData);
	}
	
	/**
	 * 
	 * 生产输出Excel的title，输出title按照种类分，顺序为：
	 * 断言结果（和期望值相对应）				固定输出	数据库流水 耗时情况	案例说明		会话秘钥	业务请求入参	期望值入参		
	 * 
	 * assert_error_no	assert_status	assert_respcd	assert_respinfo	db_assert_mPSSim	db_assert_respCd	db_assert_respInfo	sysseqnb	results	交易耗时（毫秒）	交易响应时间	交易发起时间	数据库字段结果的json格式	数据库流水时差（毫秒）	数据库结束时间	数据库开始时间	caseNo	case_desc	ptyKey	funcNo	toSign_ptyacct	toSign_ptycd	toPicBase64_videopic	usernm	toAes_toUrl_toBase64_certseq	toSign_biztyp	toSign_biztypdesc	toSign_placeid	toSign_timestamp	toSign_sourcechnl	expected_error_no	expected_status	expected_respcd	expected_respinfo	db_expected_mPSSim	db_expected_respCd	db_expected_respInfo
	 * 
	 * 包括通过期望值入参合并单元格信息expected得到断言结果（true或者false，其中false的标红，和期望值相对应）title
	 * 若expected的结束列列号为-1，表示其也为最后一个单元格，则可确定期望值入参title持续到第二行title字段名结尾
	 * 
	 * @param titleMap
	 * @param typeRowMap
	 * @return
	 */
	private List<List<String>> produceOutPutTitle(Map<Integer,String> titleMap,MyInputExcelRowColData expected){
		
		
		List<List<String>> outPutTitles=new ArrayList<List<String>>();
		
		ArrayList<String> outPutTitle=new ArrayList<String>();
		
		int colStartIndexIncluded=expected.getColStartIndexIncluded();
		int colEndIndexExclude=expected.getColEndIndexExcluded();
		if(colEndIndexExclude<0) {//为最后一个合并单元格，则colEndIndexExclude更新为第二行标题数目
			colEndIndexExclude=titleMap.values().size();
		}

		//[colStartIndexIncluded，colEndIndexExclude）区间内都是期望值入参
		IntStream.range(colStartIndexIncluded, colEndIndexExclude)
		.forEach(i->{
			String base=titleMap.get(i);
			if(null!=base) {
				if(base.startsWith(Util.DB_EXPECTED_HEAD))
					base=base.replaceFirst(Util.DB_EXPECTED_HEAD, Util.DB_ASSERTED_HEAD);//先小范围的db_expected_
				else if(base.startsWith(Util.EXPECTED_HEAD))
					base=base.replaceFirst(Util.EXPECTED_HEAD, Util.ASSERTED_HEAD);//再大范围的expected_
			}
			
			outPutTitle.add(base);
		});
		
		outPutTitle.addAll(ChangelessOutput.TITLE_LIST);
		
		outPutTitle.addAll(ConsumingTime.TITLE_LIST);
		
		outPutTitle.addAll(DbOutput.TITLE_LIST);
		
		outPutTitle.addAll(titleMap.values());
		
		outPutTitles.add(outPutTitle);
		
		log.info("outPutTitles="+JSON.toJSONString(outPutTitles));
		
		return outPutTitles;
	}
	
	
	/**
	 * 
	 * 其他行为数据行row的逐行处理
	 * 
	 * 根据titleMap和数据分类typeRowMap生成：
	 * 字段名到字段值的映射，案例说明
	 * 字段名到字段值的映射，会话秘钥
	 * 字段名到字段值的映射，业务请求入参
	 * 字段名到字段值的映射，期望值入参
	 * 
	 * 
	 * titleMap是title列号和title值映射
	 * 
	 * 数据分类typeRowMap包括三部分：
	 * 1 期望值入参的合并单元格信息；
	 * 2 除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属数组映射；数组下表代表此title类别占有的列号，数组值代表合并单元格信息（尤其包括title类别）
	 * 3 最后一个合并单元格信息
	 * 
	 * @param titleMap 是title列号和title值映射
	 * @param typeRowMap 包括三部分：
	 * 1 期望值入参的合并单元格信息；
	 * 2 除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属数组映射；数组下表代表此title类别占有的列号，数组值代表合并单元格信息（尤其包括title类别）
	 * 3 最后一个合并单元格信息
	 * @param row 数据行
	 * @return
	 */
	private InputRowData processDataRow(Map<Integer,String> titleMap,TypeRowMap typeRowMap,Collection<MyInputExcelRowColData> row){
		
		log.info("其他行为数据行的逐行处理...");
		
		//字段名到字段值的映射，案例说明
		Map<String,String> caseDes=new HashMap<String,String>();
		
		//字段名到字段值的映射，业务请求入参
		Map<String,String> params=new HashMap<String,String>();
				
		//字段名到字段值的映射，期望值入参
		Map<String,String> expected=new HashMap<String,String>();
		
		InputRowData inputRowData=new InputRowData();
		
		row.forEach(
				t->{
					//数据对应的第二行title
					String title=titleMap.get(t.getColStartIndexIncluded());//字段名
					
					//数据对应的第一行种类
					MyInputExcelRowColData typeData=null;
					if(t.getColStartIndexIncluded()>=typeRowMap.getMyMap().length) {
						typeData=typeRowMap.getLastMyInputExcelRowColData();
					}else {
						typeData=typeRowMap.getMyMap()[t.getColStartIndexIncluded()];
					}
					String type=typeData.getValue();//字段种类
					
					switch(type) {
					case Util.EXPECTED_STR:
						expected.put(title,t.getValue());
						return;
					case Util.PTY_KEY_STR:
						inputRowData.setPtyKey(t.getValue());//会话秘钥
						return;
					case Util.CASE_DESC_STR:
						caseDes.put(title,t.getValue());
						return;
					case Util.PARAMS_STR:
						params.put(title,t.getValue());
						return;
					default:
						throw new IllegalArgumentException("数据类型错误为"+type+"。数据为"+t);
					}
					
				}
		);
		
		// 会忽略空单元格，因此，主动补齐params
		titleMap.forEach((k,v)->{
			
			//数据对应的第一行种类
			MyInputExcelRowColData typeData=null;
			if(k>=typeRowMap.getMyMap().length) {
				typeData=typeRowMap.getLastMyInputExcelRowColData();
			}else {
				typeData=typeRowMap.getMyMap()[k];
			}
			String type=typeData.getValue();//字段种类
			
			if(Util.PARAMS_STR.equals(type)&&!params.containsKey(v))//是接口请求入参params，且没有此字段，则填充补齐空字符串
				params.put(v, "");
		});
		
		inputRowData.setCaseDes(caseDes);
		inputRowData.setExpected(expected);
		inputRowData.setParams(params);
		
		if(null==inputRowData.getPtyKey()) {
			String msg="入参中"+Util.PTY_KEY_STR+"不能为空";
			log.error(msg);
			throw new IllegalArgumentException(msg);
		}
		
		log.info("其他行为数据行的逐行处理完成,inputRowData="+JSON.toJSONString(inputRowData));
		
		return inputRowData;

	}
	
	/**
	 * 处理第二行title数据row为输入数据字段名
	 * 
	 * 无合并单元格
	 * 如
	 * caseNo	case_desc	ptyKey	funcNo	toSign_ptyacct	toSign_ptycd	toPicBase64_videopic	usernm	toAes_toUrl_toBase64_certseq	toSign_biztyp	toSign_biztypdesc	toSign_placeid	toSign_timestamp	toSign_sourcechnl	expected_error_no	expected_status	expected_respcd	expected_respinfo	db_expected_mPSSim	db_expected_respCd	db_expected_respInfo
	 * 
	 * 生成title映射
	 * 主键为MyInputExcelRowColData的 getColStartIndexIncluded（即title列号），值为MyInputExcelRowColData的getValue（即title值）
	 * 
	 * @param row 第二行title为输入数据字段名
	 * 是对应VBA接口文档的输入字段名，
	 * 根据是否参加签名，是否aes加密再url编码再base64编码形式post，是否文件路径读入图片base64编码后的字符串post，
	 * 相应的添加toSign_开头，oAes_toUrl_toBase64_开头，toPicBase64__开头
	 * @return
	 */
	private Map<Integer,String> processTitleRow(Collection<MyInputExcelRowColData> row){
		
		log.info("第二行title为输入数据字段名的处理...");
		
		Map<Integer,String> titleMap = new HashMap<Integer,String>();
		row.forEach(t->{
			titleMap.put(t.getColStartIndexIncluded(), t.getValue());
			});
		
		log.info("第二行title为输入数据字段名的处理完成,titleMap="+JSON.toJSONString(titleMap));
		return titleMap;
	}

	/**
	 * 
	 * 读入处理第一行输入数据分类title
	 * 
	 * 
	 * 模板第一行title数据row，是输入数据分类，包括:
	 * 案例说明:其下的所有列只供人查阅，程序并不使用	
	 * 会话秘钥:必须有	
	 * 业务请求入参:其下的所有列，根据不同服务，入参数目不一，都遵循：
	 * 一业务请求入参title规则：
	 * 1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
	 * 2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 * 3 toPicBase64__开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 * 4 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
	 * 
	 * 二：业务请求入参值规则：
	 * 1 spec_则是默认固定值
	 * 2 spec_time是程序自动取当前时间
	 * 3 否则，填写什么值就使用什么值
	 * 
	 * 大小写敏感	
	 * 									
	 * 期望值入参：其下的所有列表示期望得到的返回结果，用于获得断言输出
	 * 
	 * 
	 * 据此生成
	 *第一行title类别的读入处理结果
	 * 
	 * 包括三部分：
	 * 1 期望值入参的合并单元格信息；
	 * 2 除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属数组映射；数组下表代表此title类别占有的列号，数组值代表合并单元格信息（尤其包括title类别）
	 * 3 最后一个合并单元格信息
	 * 
	 * 
	 * @param row
	 * 模板第一行title数据，是输入数据分类，包括:
	 * 案例说明:其下的所有列只供人查阅，程序并不使用	
	 * 会话秘钥:必须有	
	 * 业务请求入参:其下的所有列，根据不同服务，入参数目不一，都遵循：
	 * 一业务请求入参title规则：
	 * 1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
	 * 2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 * 3 toPicBase64__开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 * 4 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
	 * 
	 * 二：业务请求入参值规则：
	 * 1 spec_则是默认固定值
	 * 2 spec_time是程序自动取当前时间
	 * 3 否则，填写什么值就使用什么值
	 * 
	 * 大小写敏感	
	 * 									
	 * 期望值入参：其下的所有列表示期望得到的返回结果，用于获得断言输出
	 * @return
	 */
	private TypeRowMap processTypeRow(Collection<MyInputExcelRowColData> row) {
		log.info("第一行title为，是输入数据分类的处理...");
		
		//最后一个合并单元格
		Optional<MyInputExcelRowColData> lastMyInputExcelRowColDataOptional=row.stream()
				.filter(t->-1==t.getColEndIndexExcluded())
				.findFirst();		
		MyInputExcelRowColData lastMyInputExcelRowColData=lastMyInputExcelRowColDataOptional.orElse(null);
		
		//期望值入参的合并单元格
		Optional<MyInputExcelRowColData> expectedOptional=row.stream()
				.filter(t->-1==t.getColEndIndexExcluded())
				.findFirst();		
		MyInputExcelRowColData expected=expectedOptional.orElse(null);
		
		TypeRowMap type=new TypeRowMap();
		type.setLastMyInputExcelRowColData(lastMyInputExcelRowColData);
		type.setExpected(expected);
		
		OptionalInt lenOptionalInt=row.stream()
				.mapToInt(MyInputExcelRowColData::getColEndIndexExcluded)
				.max();
		
		int len=lenOptionalInt.orElse(0);
		if(0==len) {
			log.warn("读入输入数据分类title,数据列数为0");
			return type;
		}
		
		//除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属数组映射；数组下表代表此title类别占有的列号，数组值代表合并单元格信息（尤其包括title类别）
		final MyInputExcelRowColData[] myMap=new MyInputExcelRowColData[len];
		
		row.forEach(
				t->{
					
					if(t.getColEndIndexExcluded()<t.getColStartIndexIncluded()) {
						log.warn("t.getColEndIndexExcluded()<t.getColStartIndexIncluded()");
						return;
					}
					
					IntStream.range(t.getColStartIndexIncluded(), t.getColEndIndexExcluded())//拆散合并的单元格
						.forEach(
								n->{
									myMap[n]=t;
								});
						
				});
		
		type.setMyMap(myMap);
		
		log.info("第一行title，是输入数据分类的处理完成,type="+JSON.toJSONString(type));
		return type;
	}



	@Override
	public List<List<String>> getOutPutTitle() {
		return outPutTitles;
	}


	@Override
	public void setController(Controller controller) {
		this.controller=controller;
	}
	
}
