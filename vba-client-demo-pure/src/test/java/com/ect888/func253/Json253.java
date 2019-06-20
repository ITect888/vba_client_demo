package com.ect888.func253;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 253查询结果
 * 对应json
 * {
"error_no": "0",
"results": [{
		"respcd": "50000",
		"respinfo": "认证一致(通过)",
		"status": "00",
		"ptycd": "testcd",
		"ptyAcct": "testacct",
		"sysSeqNb": "19103520190131041632380003",
		"biztyp": "A001",
		"localsim": "85.61"
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
public class Json253 extends JsonCommon{

	private ArrayList<Result253> results;

	public ArrayList<Result253> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result253> results) {
		this.results = results;
	}
	
	

}
