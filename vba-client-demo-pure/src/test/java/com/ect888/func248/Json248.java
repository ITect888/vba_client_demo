package com.ect888.func248;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 对应json
 * {
	"error_no": "0",
	"results": [{
			"respcd": "48000",
			"certseq": "61030219910118512X",
			"cmpResult": "{\"resAddress\":\"省一致/市一致/县（区）一致\",\"resBirthday\":\"一致\",\"resCertSeq\":\"一致\",\"resCsdssx\":\"省一致/市不一致/县（区）不一致\",\"resCym\":\"\",\"resEducation\":\"一致\",\"resEthnicity\":\"一致\",\"resFwcs\":\"\",\"resJgssx\":\"省一致/市不一致/县（区）不一致\",\"resMarrige\":\"一致\",\"resName\":\"一致\",\"resSex\":\"一致\",\"resSsssxq\":\"\"}",
			"respinfo": "认证一致",
			"status": "00",
			"name": "姓名",
			"ptycd": "xikanglan",
			"ptyAcct": "xikanglan",
			"facePicMPS": "",
			"sysSeqNb": "19103520190313621654300001",
			"biztyp": "A001"
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
public class Json248 extends JsonCommon{

	private ArrayList<Result248> results;

	public ArrayList<Result248> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result248> results) {
		this.results = results;
	}
	
}