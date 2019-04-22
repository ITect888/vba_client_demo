package com.ect888.bus.view.impl;

import lombok.Data;

/**
 * 
 * 
 * 第一行title类别的读入处理结果
 * 
 * 包括三部分：
 * 1 期望值入参的合并单元格信息；
 * 2 除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属数组映射；数组下表代表此title类别占有的列号，数组值代表合并单元格信息（尤其包括title类别）
 * 3 最后一个合并单元格信息
 * 
 * @author fanyj
 *
 */
@Data
public class TypeRowMap {

	/**
	 * 最后一个合并单元格信息
	 * 
	 * 最后一个合并单元格无法获知长度，
	 * 其spanColCount设置为-1表示此合并单元格开始列的列号后全部算进
	 */
	private MyInputExcelRowColData lastMyInputExcelRowColData;
	
	/**
	 * 除最后一个合并单元格外，其他合并单元格拆出后散列到各单个列的所属
	 */
	private MyInputExcelRowColData[] myMap; 
	
	/**
	 * 期望值入参的合并单元格信息
	 */
	private MyInputExcelRowColData expected;
}
