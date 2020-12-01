package com.ect888.func231;

import com.ect888.bean.JsonCommon;

import java.util.ArrayList;

/**
 * 
 * 207查询结果
 * 对应json
 * {
    "error_no":"0",
    "results":[
        {
            "sysSeqNb":"19103520190309801851220001",
            "biztyp":"A001",
            "accountName":"工商银行"
            "ptyAcct":"ect888_public_demo",
            "ptycd":"ect888_public",
            "respinfo":"查询成功",
            "respcd":"37000",
            "status":"00",
        }
    ],
    "dsName":[
        "results"
    ],
    "error_info":""

 * 
 * @author linyw
 *
 */
public class Json231 extends JsonCommon{

	private Result231 results;

	public Result231 getResults() {
		return results;
	}

	public void setResults(Result231 results) {
		this.results = results;
	}
}
