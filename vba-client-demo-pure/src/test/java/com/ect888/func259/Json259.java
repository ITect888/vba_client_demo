package com.ect888.func259;

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
			"respcd": "53000",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611705190001",
			"phoneProvCity": "上海",
			"status": "00",
			"ptyacct": "ciasacct",
			"phoneOperator": "移动",
			"ptycd": "0000100000",
			"usernm": "姓名",
			"phoneno": "15121016666"
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
public class Json259 extends JsonCommon{

	private ArrayList<Result259> results;

	public ArrayList<Result259> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result259> results) {
		this.results = results;
	}
	
	

}
