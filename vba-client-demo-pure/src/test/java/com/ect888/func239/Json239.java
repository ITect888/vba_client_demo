package com.ect888.func239;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 239查询结果
 * 对应json
{
    "error_no":"0",
    "results":[
        {
            "respinfo":"认证一致(通过)",
            "phoneProvCity":"",
            "status":"00",
            "phoneOperator":"移动",
            "biztyp":"A001",
            "respcd":"10000",
            "certseq":"341227198912173710",
            "resultdata":"0",
            "sysseqnb":"19103520190309801921280001",
            "name":"姓名",
            "ptyacct":"ect888_public_demo",
            "ptycd":"ect888_public",
            "phoneno":"15298386506"
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
public class Json239 extends JsonCommon{

	private ArrayList<Result239> results;

	public ArrayList<Result239> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result239> results) {
		this.results = results;
	}
	
	

}
