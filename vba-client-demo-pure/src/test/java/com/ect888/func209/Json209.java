package com.ect888.func209;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 102查询结果
 * 对应json
 * {
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"localsim": "",
			"biztyp": "A001",
			"certseq": "341227198912173710",
			"accountName": "",
			"mpssim": "88.0",
			"telephone": "",
			"respinfo": "认证�?�?(通过)",
			"sysSeqNb": "19103520181012221215290001",
			"ptycd": "12500000",
			"facePicMPS": "",
			"name": "系统判断为同�?�?",
			"cerkey": "",
			"ptyAcct": "12500000",
			"respcd": "1000",
			"status": "00"
		}
	],
	"error_no": "0"
}
�?
{"error_info":"网络不可用，请稍后再�?","error_no":"-1006"}
 * 
 * @author fanyj
 *
 */
public class Json209 extends JsonCommon{

	private ArrayList<Result209> results;

	public ArrayList<Result209> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result209> results) {
		this.results = results;
	}
	
	

}
