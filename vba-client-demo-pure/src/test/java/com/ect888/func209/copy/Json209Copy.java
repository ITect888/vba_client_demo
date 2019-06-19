package com.ect888.func209.copy;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 实名认证快速转发查询结果
 * 对应json
{
	"error_no": "0",
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"sysSeqNb": "19103520190603881258500003",
			"respcd": "5000",
			"respinfo": "认证一致(通过)"
		}
	]
}
 * 
 * @author fanyj
 *
 */
public class Json209Copy extends JsonCommon{

	private ArrayList<Result209Copy> results;

	public ArrayList<Result209Copy> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result209Copy> results) {
		this.results = results;
	}
	
	

}
