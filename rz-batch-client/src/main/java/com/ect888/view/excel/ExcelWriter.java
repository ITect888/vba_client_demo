package com.ect888.view.excel;

import java.io.IOException;
import java.util.List;

public interface ExcelWriter {

	/**
	 * 
	 * 能写合并单元格的title
	 * 
	 * @param fileName
	 * @param titleCol
	 * @throws IOException
	 */
	public void reset(String fileName, List<String> titleLists)
			throws IOException;

	public int getColnum();

	public int getRownum();
	
	/**
	 * 
	 * 能写合并单元格的
	 * 
	 * @param col
	 * @throws IOException
	 */
	public void addRow(List<String> lists) throws IOException;

	public void writeAndClose() throws IOException;
}
