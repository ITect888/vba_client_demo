package com.ect888.func264;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 264查询结果
 * 对应json
{
    "error_info":"",
    "dsName":[
        "results"
    ],
    "results":[
        {
            "usernm":"林雨微",
            "certseq":"610302199101185125",
            "ptycd":"ect888_linyw",
            "ptyacct":"ect888_linyw",
            "respinfo":"认证一致(通过)",
            "sysseqnb":"19103520190326221802320001",
            "respcd":"58000",
            "status":"00"
        }
    ],
    "error_no":"0"
}
 * 
 * @author fanyj
 *
 */
public class Json264 extends JsonCommon{

	private ArrayList<Result264> results;

	public ArrayList<Result264> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result264> results) {
		this.results = results;
	}
	
	

}
