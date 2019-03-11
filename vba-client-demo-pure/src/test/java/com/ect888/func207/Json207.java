package com.ect888.func207;

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
            "cerkey":"",
            "respinfo":"认证一致(通过)",
            "status":"00",
            "mpssim":"0.0",
            "biztyp":"A001",
            "sysSeqNb":"19103520190309801851220001",
            "respcd":"2000",
            "certseq":"341227198912173710",
            "accountName":"工商银行",
            "name":"姓名",
            "ptyAcct":"ect888_public_demo",
            "ptycd":"ect888_public",
            "localsim":"0.0",
            "telephone":"15298386506"
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
public class Json207 extends JsonCommon{

	private ArrayList<Result207> results;

	public ArrayList<Result207> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result207> results) {
		this.results = results;
	}
	
	

}
