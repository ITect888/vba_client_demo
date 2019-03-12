package com.ect888.func252;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 252查询结果
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
			"respinfo": "认证一致(通过)",
			"sysSeqNb": "19103520181012221215290001",
			"ptycd": "12500000",
			"facePicMPS": "",
			"name": "系统判断为同一人",
			"cerkey": "",
			"ptyAcct": "12500000",
			"respcd": "1000",
			"status": "00"
		}
	],
	"error_no": "0"
}
 * 
 * @author fanyj
 *
 */
public class Json252 extends JsonCommon{

	private ArrayList<Result252> results;

	public ArrayList<Result252> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result252> results) {
		this.results = results;
	}
	
	

}
