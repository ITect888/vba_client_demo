package com.ect888.func262;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 262查询结果
 * 对应json
 *{
	"error_no": "0",
	"results": [{
			"respcd": "56000",
			"birthday": "20190222",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611615230001",
			"status": "00",
			"validity": "20190222",
			"ptyacct": "ciasacct",
			"ptycd": "0000100000",
			"usernm": "证件上中文名",
			"passport": "341227198912173710"
		}
	],
	"dsName": ["results"],
	"error_info": ""
}


或
{"error_info":"网络不可用，请稍后再试","error_no":"-1006"}
 * 
 * @author fanyj
 *
 */
public class Json262 extends JsonCommon{

	private ArrayList<Result262> results;

	public ArrayList<Result262> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result262> results) {
		this.results = results;
	}
	
	

}
