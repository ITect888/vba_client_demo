package com.ect888.func242;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 242结果
 * 对应json
 * {
	"error_no": "0",
	"results": [{
			"visit_frequency_day_level": "高",
			"respinfo": "查得",
			"status": "00",
			"addr": "a_家庭_f_12_i_11_l_true_v_高",
			"sysSeqNb": "19103520181108801700040001",
			"biztyp": "A001",
			"inactive_day": "11",
			"respcd": "42000",
			"certseq": "341227198912173710",
			"fre_location": "true",
			"name": "测试姓名",
			"addr_label": "家庭",
			"frequency_day": "12",
			"ptyAcct": "ect888_public_demo",
			"ptycd": "ect888_public",
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
public class Json242 extends JsonCommon{

	private ArrayList<Result242> results;

	public ArrayList<Result242> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result242> results) {
		this.results = results;
	}
	
}