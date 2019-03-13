package com.ect888.func256;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 结果
 * 对应json
 * {
	"error_no": "0",
	"results": [{
			"respcd": "51000",
			"respinfo": "比中失效身份证",
			"status": "00",
			"sysSeqNb": "19103520190313801524300001"
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
public class Json256 extends JsonCommon{

	private ArrayList<Result256> results;

	public ArrayList<Result256> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result256> results) {
		this.results = results;
	}
	
}