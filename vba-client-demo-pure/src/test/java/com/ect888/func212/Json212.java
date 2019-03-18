package com.ect888.func212;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 102查询结果
 * 对应json
 *{
	"depreciated": false,
	"errorCode": "0",
	"value": {
		"resultNum": "1",
		"resultSet": [{
				"iscriminal": "2,1,3,9,5,4,6,8,7",
				"caseType": "6070000",
				"caseTime": "[5,10)",
				"respinfo": "查询成功",
				"status": "00",
				"biztyp": "CIAS",
				"provinceNo": "23",
				"respcd": "8000",
				"certseq": "341227198912173710",
				"sysseqnb": "401320190315011013210001",
				"name": "姓名",
				"newestDate": "[5,10)",
				"ptyacct": "ciasacct",
				"badCnt": "1",
				"ptycd": "0000100000"
			}
		]
	}
}

	或
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
