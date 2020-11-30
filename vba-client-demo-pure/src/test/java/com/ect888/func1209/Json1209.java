package com.ect888.func1209;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 209查询结果
 * 对应json
{
    "error_no":"0",
    "results":[
        {
            "cerkey":"",
            "respinfo":"认证一致(通过)",
            "status":"00",
            "mpssim":"0.0",
            "biztyp":"A001",
            "sysSeqNb":"19103520190308802006580001",
            "respcd":"5000",
            "certseq":"341227198912173710",
            "accountName":"",
            "name":"姓名",
            "ptyAcct":"ect888_public_demo",
            "ptycd":"ect888_public",
            "localsim":"",
            "telephone":""
        }
    ],
    "dsName":[
        "results"
    ],
    "error_info":""
}
 * 
 * @author linyw
 *
 */
public class Json1209 extends JsonCommon{

	private ArrayList<Result1209> results;

	public ArrayList<Result1209> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result1209> results) {
		this.results = results;
	}
	
	

}
