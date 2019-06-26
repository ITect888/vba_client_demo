package com.ect888.func224;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 224查询结果
 * 对应json
{
	"error_info": "",
	"dsName": ["results"],
	"results": [{
			"biztyp": "A001",
			"ptycd": "linyw",
			"ptyacct": "linyw",
			"respinfo": "认证不一致(不通过):身份证号:一致,姓名:一致,档案编号:不一致",
			"sysseqnb": "19103520190626220939200001",
			"respcd": "24001",
			"status": "00"
		}
	],
	"error_no": "0"
}
 * 
 * @author linyw
 *
 */
public class Json224 extends JsonCommon{

	private ArrayList<Result224> results;

	public ArrayList<Result224> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result224> results) {
		this.results = results;
	}
	
	

}
