package com.ect888.func237;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

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
            "accountID":"01035800",
            "acctType":"借记卡",
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
public class Json237 extends JsonCommon{

	private ArrayList<Result237> results;

	public ArrayList<Result237> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result237> results) {
		this.results = results;
	}
	
	

}
