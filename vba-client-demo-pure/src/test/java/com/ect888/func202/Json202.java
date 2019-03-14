package com.ect888.func202;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 202返回结果
 * 对应json
{
	"error_no": "0",
	"results": [{
			"birthday": "1974年3月24日",
			"certseq": "610104197403243450",
			"sex": "男",
			"issue": "西安市公安局莲湖分局",
			"addr": "西安市莲湖区工农路22号9号楼46号",
			"usernm": "申方敏",
			"expirydate": "2014.10.08-2034.10.08",
			"nation": ""
		}
	],
	"dsName": ["results"],
	"error_info": ""
}
 * 
 * @author fanyj
 *
 */
public class Json202 extends JsonCommon{

	private ArrayList<Result202> results;

	public ArrayList<Result202> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result202> results) {
		this.results = results;
	}
	
	

}
