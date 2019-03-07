package com.ect888.func249;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 249查询结果
 * 对应json
 * {
	"error_no": "0",
	"results": [{
			"retirementYear": "",
			"doors": "四门",
			"respinfo": "行驶证查询成功：有数据",
			"VIN": "L6T7824ZXFN033628",
			"registerDate": "2015-08-26 10:50:34",
			"productiveYear": "2015",
			"line": "帝豪",
			"sysSeqNb": "19103520190306611224310001",
			"biztyp": "A001",
			"type": "轿车",
			"releaseYear": "2015",
			"ROZ": "93#",
			"respcd": "49000",
			"carType": "帝豪-三厢",
			"level": "紧凑型车",
			"effluentStandard": "国5",
			"style": "三厢",
			"sellName": "1.5 无级 向上版",
			"seats": "5",
			"year": "2015",
			"ptycd": "0000100000",
			"cylinders": "4",
			"vendorName": "吉利汽车",
			"status": "00",
			"property": "A",
			"guidingPrice": "9.08",
			"code": "",
			"VIN_year": "",
			"gears": "无级",
			"drivingMeans": "前轮驱动",
			"maxPower": "80",
			"engineType": "JLγ-4G15",
			"engineNo": "F4NA06373",
			"carStatus": "A",
			"releaseMonth": "-",
			"color": "H",
			"fuelType": "汽油",
			"transmissionType": "自动",
			"gearboxDes": "无级变速器(CVT)",
			"volume": "1.5",
			"owner": "",
			"brand": "吉利",
			"ptyAcct": "ciasacct",
			"deadline": "2017-08-31 00:00:00"
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
public class Json249 extends JsonCommon{

	private ArrayList<Result249> results;

	public ArrayList<Result249> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result249> results) {
		this.results = results;
	}
	
	

}
