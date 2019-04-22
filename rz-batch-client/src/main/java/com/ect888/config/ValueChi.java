package com.ect888.config;

import lombok.Data;

/**
 * 字段值到中文映射的数据字典
 * 
 * @author fanyj
 *
 */
@Data
public class ValueChi {
	/**
	 * 字段值
	 */
	private String value;
	/**
	 * 中文
	 */
	private String chi;
}
