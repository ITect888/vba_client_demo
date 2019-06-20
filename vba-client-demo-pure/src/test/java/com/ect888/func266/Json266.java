package com.ect888.func266;

import java.util.ArrayList;

import com.ect888.bean.JsonCommon;

/**
 * 
 * 266查询结果
 * 对应json
 * 
 * @author fanyj
 *
 */
public class Json266 extends JsonCommon{

	private ArrayList<Result266> results;

	public ArrayList<Result266> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result266> results) {
		this.results = results;
	}
	
	private ArrayList<Detail_1> detail_1;

	private ArrayList<Detail_2> detail_2;
	
	private ArrayList<Detail_5> detail_5;
	
	private ArrayList<Detail_10> detail_10;

	public ArrayList<Detail_10> getDetail_10() {
		return detail_10;
	}

	public void setDetail_10(ArrayList<Detail_10> detail_10) {
		this.detail_10 = detail_10;
	}

	public ArrayList<Detail_1> getDetail_1() {
		return detail_1;
	}

	public void setDetail_1(ArrayList<Detail_1> detail_1) {
		this.detail_1 = detail_1;
	}

	public ArrayList<Detail_2> getDetail_2() {
		return detail_2;
	}

	public void setDetail_2(ArrayList<Detail_2> detail_2) {
		this.detail_2 = detail_2;
	}

	public ArrayList<Detail_5> getDetail_5() {
		return detail_5;
	}

	public void setDetail_5(ArrayList<Detail_5> detail_5) {
		this.detail_5 = detail_5;
	}
	
	private ArrayList<Detail_1_0> detail_1_0;
	
	private ArrayList<Detail_1_1> detail_1_1;

	public ArrayList<Detail_1_0> getDetail_1_0() {
		return detail_1_0;
	}

	public void setDetail_1_0(ArrayList<Detail_1_0> detail_1_0) {
		this.detail_1_0 = detail_1_0;
	}

	public ArrayList<Detail_1_1> getDetail_1_1() {
		return detail_1_1;
	}

	public void setDetail_1_1(ArrayList<Detail_1_1> detail_1_1) {
		this.detail_1_1 = detail_1_1;
	}
	
	
}
