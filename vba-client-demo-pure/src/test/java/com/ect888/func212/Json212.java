package com.ect888.func212;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 102查询结果
 * 对应json
 *{
	"error_no": "0",
	"results": [{
			"iscriminal": "",
			"caseType": "",
			"caseTime": "",
			"respinfo": "查询失败",
			"status": "03",
			"biztyp": "A001",
			"provinceNo": "",
			"respcd": "8001",
			"certseq": "422823199107192312",
			"sysseqnb": "19103520190312611704420027",
			"name": "姓名",
			"newestDate": "",
			"badCnt": "",
			"ptyacct": "xikanglan",
			"ptycd": "xikanglan"
		}
	],
	"dsName": ["results"],
	"error_info": ""
	}
 *{"error_info":"网络不可用，请稍后再试","error_no":"-1006"}
 * 
 * @author fanyj
 *
 */
public class Json212 extends JsonCommon{

	private ArrayList<Result212> results;

	public ArrayList<Result212> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result212> results) {
		this.results = results;
	}
	
	

}
