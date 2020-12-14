package com.ect888.func300;

import com.ect888.bean.JsonCommon;

import java.util.ArrayList;

/**
 * 
 * 300查询结果
 * 对应json
 * 
 * {
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"respinfo": "账户类型验证通过",
			"sysseqnb": "19103520190327221920340001",
			"respcd": "59000",
			"status": "00",
			 "score": "2",
			 "ptyacct": "koukou1",
			 "ptycd": "koukou1",
			 "bankName": "农业银行",
 			"phoneno": "17612341234"
		 }],
	"error_no": "0"
}

 * 
 * @author fanyj
 *
 */
public class Json300 extends JsonCommon{

	private ArrayList<Result300> results;

	public ArrayList<Result300> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result300> results) {
		this.results = results;
	}
	
	

}
