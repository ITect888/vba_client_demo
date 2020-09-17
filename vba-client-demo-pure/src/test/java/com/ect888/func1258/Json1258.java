package com.ect888.func1258;

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
			"respinfo": "认证一致(通过)",
			"sysSeqNb": "19103520181012221215290001",
			"ptycd": "12500000",
			"facePicMPS": "",
			"name": "系统判断为同一人",
			"cerkey": "",
			"ptyAcct": "12500000",
			"respcd": "0000",
			"status": "00"
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
public class Json1258 extends JsonCommon{

	private ArrayList<Result1258> results;

	public ArrayList<Result1258> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result1258> results) {
		this.results = results;
	}
	
}
