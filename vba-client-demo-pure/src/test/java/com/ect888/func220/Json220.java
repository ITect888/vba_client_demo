package com.ect888.func220;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 220查询结果
 * 对应json
{
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"biztyp": "A001",
			"ptycd": "linyw",
			"resultdata": "",
			"ptyacct": "linyw",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190903222014370001",
			"respcd": "21000",
			"status": "00"
		}
	],
	"error_no": "0"
}
 * 
 * @author linyw
 *
 */
public class Json220 extends JsonCommon{

	private ArrayList<Result220> results;

	public ArrayList<Result220> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result220> results) {
		this.results = results;
	}
	
	

}
