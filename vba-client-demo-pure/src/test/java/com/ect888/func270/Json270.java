package com.ect888.func270;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 270查询结果
 * 对应json
 * 
 * {
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"respinfo": "账户类型验证通过",
			"sysseqnb": "19103520190624222153590001",
			"respcd": "65200",
			"status": "00"
		}
	],
	"error_no": "0"
}

 * 
 * @author fanyj
 *
 */
public class Json270 extends JsonCommon{

	private ArrayList<Result270> results;

	public ArrayList<Result270> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result270> results) {
		this.results = results;
	}
	
	

}
