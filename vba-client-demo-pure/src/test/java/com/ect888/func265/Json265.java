package com.ect888.func265;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 265查询结果
 * 对应json
 * 
 * {
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"respinfo": "账户类型验证通过",
			"sysseqnb": "19103520190327221920340001",
			"respcd": "59000",
			"status": "00"
		}
	],
	"error_no": "0"
}

 * 
 * @author fanyj
 *
 */
public class Json265 extends JsonCommon{

	private ArrayList<Result265> results;

	public ArrayList<Result265> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result265> results) {
		this.results = results;
	}
	
	

}
