package com.ect888.func209;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 209查询结果
 * 对应json
{
	"error_no": "0",
	"results": [{
			"cerkey": "",
			"respinfo": "认证一致(通过)",
			"status": "00",
			"mpssim": "0.0",
			"biztyp": "A001",
			"sysSeqNb": "19103520190311611014140001",
			"respcd": "5000",
			"certseq": "341227198912173710",
			"accountName": "",
			"name": "姓名",
			"ptyAcct": "ciasacct",
			"ptycd": "0000100000",
			"localsim": "",
			"telephone": ""
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
public class Json209 extends JsonCommon{

	private ArrayList<Result209> results;

	public ArrayList<Result209> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result209> results) {
		this.results = results;
	}
	
	

}
