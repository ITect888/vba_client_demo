package com.ect888.func261;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 261查询结果
 * 对应json
 *{
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"platetype": "02",
			"carStatus": "G",
			"ptycd": "12500000",
			"ptyacct": "12500000",
			"respinfo": "查询成功-认证一致",
			"sysseqnb": "19103520190220221411550001",
			"respcd": "55000",
			"status": "00",
			"registerDate": "20161123"
		}
	],
	"error_no": "0"
}

或
{"error_info":"网络不可用，请稍后再试","error_no":"-1006"}
 * 
 * @author fanyj
 *
 */
public class Json261 extends JsonCommon{

	private ArrayList<Result261> results;

	public ArrayList<Result261> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result261> results) {
		this.results = results;
	}
	
	

}
