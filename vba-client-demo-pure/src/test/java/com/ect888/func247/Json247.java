package com.ect888.func247;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 对应json
 * {
	"error_no": "0",
	"results": [{
			"respinfo": "识别失败",
			"status": "03",
			"cardNumberImage": "",
			"accountCard": "",
			"biztyp": "0",
			"sysSeqNb": "19103520190318611017060001",
			"cardType": "",
			"validate": "",
			"respcd": "47001",
			"accountName": "",
			"name": "",
			"ptycd": "0000100000",
			"ptyAcct": "ciasacct"
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
public class Json247 extends JsonCommon{

	private ArrayList<Result247> results;

	public ArrayList<Result247> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result247> results) {
		this.results = results;
	}
	
}