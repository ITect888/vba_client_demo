package com.ect888.func257;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 257查询结果
 * 对应json
 *{
	"error_no": "0",
	"results": [{
			"respcd": "52000",
			"certseq": "341227198912173710",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611530150001",
			"status": "00",
			"validto": "20380327",
			"ptyacct": "ciasacct",
			"ptycd": "0000100000",
			"usernm": "姓名",
			"validfrom": "20180327"
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
public class Json257 extends JsonCommon{

	private ArrayList<Result257> results;

	public ArrayList<Result257> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result257> results) {
		this.results = results;
	}
	
	

}
