package com.ect888.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * 字段值需要中文映射的  
 * 
 * @author fanyj
 *
 */
@Data
public class FieldValueChi {

	/**
	 * 字段
	 */
	private String field;
	/**
	 * 数据字典集合
	 */
	private List<ValueChi> value2chiList=new ArrayList<>();
}
