package com.ect888.view.excel.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ect888.view.excel.ExcelWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 原型模式
 * 
 * @author fanyj
 *
 */
@Component
@Scope("prototype")
@Slf4j
public class Excel2007Writer implements ExcelWriter {

	/**
	 * keep MAX_ROWS_IN_MEMORY_EXCEL rows in memory, exceeding rows will be flushed to disk
	 */
	public static final int MAX_ROWS_IN_MEMORY_EXCEL = 10000;// 
	
	private FileOutputStream out;
	private Workbook wb;
	private Sheet s;

	@Override
	public void reset(String fileName, List<String> titleLists)
			throws IOException {
		log.info("start to write " + fileName);
		// create a new file
		out = new FileOutputStream(fileName);
		// create a new workbook
		wb = new SXSSFWorkbook(MAX_ROWS_IN_MEMORY_EXCEL);
		// create a new sheet
		s = wb.createSheet();

		rownum = 0;
		addRow(titleLists);
		colnum = titleLists.size();
	}

	int colnum;

	@Override
	public int getColnum() {
		return colnum;
	}

	int rownum;

	@Override
	public int getRownum() {
		return rownum;
	}
	
	//线程安全
	private synchronized int conRonnum(){
		return rownum++;
	}

	@Override
	public void addRow(List<String> lists) throws IOException {

		Row r = s.createRow(conRonnum());

		IndexRef i=new IndexRef();
		i.setIndex(0);
		
		lists.forEach(value->{
			int curI=i.getIndex();
			Cell c = r.createCell(curI);
			if(null!=value&&value.length()>32767) {//java.lang.IllegalArgumentException: The maximum length of cell contents (text) is 32,767 characters
				log.warn("值过大，将被截取，只保留前"+32767);
				value=value.substring(0, 32767);
			}
			c.setCellValue(value);
			i.setIndex(curI+1);
		});
		
	}
	
	@Override
	public void writeAndClose() throws IOException {
		// write the workbook to the output stream
		// close our file (don't blow out our file handles
		wb.write(out);
		out.close();
		wb.close();

		log.info("end writing. ");
	}

}
