package com.ect888.bus.view.impl;

import lombok.Data;

/**
 * 
 * excel指定行和列数据（包括合并单元格）对应信息，包括：
 * 0 String 值
 * 1 行号（从0开始）
 * 2 每个值开始列的列号（从0开始）,包括此列号
 * 3 每个结束列的列号（从0开始）,不包括此列号,最后一个合并单元格无法获知结束咧，设置为-1表示此合并单元格开始列的列号后全部算进
 * 
 * @author fanyj
 *
 */
@Data
public class MyInputExcelRowColData {
	/**
	 * String 值
	 */
	private String value;
	/**
	 * 行号（从0开始）
	 */
	private int rowIndex;
	/**
	 * 每个值开始列的列号（从0开始）
	 * 包括此列号
	 */
	private int colStartIndexIncluded;
	/**
	 * 每个结束列的列号（从0开始）
	 * 不包括此列号
	 * 
	 * 最后一个合并单元格无法获知结束咧，设置为-1表示此合并单元格开始列的列号后全部算进
	 */
	private int colEndIndexExcluded;
	
}
