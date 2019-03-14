package com.ect888.func240;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 240查询结果
 * 对应json
 *
 *{
 *	"error_no": "0",
	"results": [{
			"respinfo": "查得",
			"status": "00",
			"verify_result": "C",
			"addr": "c_高_f_11_i_2_m_WW_v_true_r_C",
			"sysSeqNb": "19103520181107801532480001",
			"biztyp": "A001",
			"confidence": "高",
			"inactive_day": "2",
			"respcd": "40000",
			"certseq": "341227198912173710",
			"validity": "true",
			"name": "测试姓名",
			"frequency_day": "11",
			"ptyAcct": "ect888_public_demo",
			"ptycd": "ect888_public",
			"phoneno": "15121016666"
		],
	"dsName": ["results"],
	"error_info": ""
 *}
 *或
 *{"error_info":"网络不可用，请稍后再试","error_no":"-1006"}
 * 
 * @author fanyj
 *
 */
public class Json240 extends JsonCommon{

	private ArrayList<Result240> results;

	public ArrayList<Result240> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result240> results) {
		this.results = results;
	}
	
	

}
