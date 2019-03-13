package com.ect888.func210;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 259查询结果
 * 对应json
 *
 *{
	"error_no": "0",
	"results": [{
			"respcd": "12000",
			"certseq": "",
			"cerkey": "",
			"accountname": "农业银行",
			"respinfo": "认证一致（通过）",
			"sysseqnb": "19103520190312611840110065",
			"status": "00",
			"name": "姓名",
			"ptyacct": "xikanglan",
			"ptycd": "xikanglan",
			"biztyp": "0541",
			"telephone": ""
		}
	],
	"dsName": ["results"],
	"error_info": ""
 *}
 *或
 *{"error_info":"网络不可用，请稍后再试","error_no":"-1006"}
 * 
 * @author fanyj
 *
 */
public class Json210 extends JsonCommon{

	private ArrayList<Result210> results;

	public ArrayList<Result210> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result210> results) {
		this.results = results;
	}
	
	

}
