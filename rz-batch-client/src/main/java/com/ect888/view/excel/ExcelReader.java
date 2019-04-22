package com.ect888.view.excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

import com.ect888.bus.view.CallBack;

/**
 * 
 */
public interface ExcelReader {


	/**
	 * 
	 * 读文件file并对每行数据回调call处理
	 * 
	 * @param file
	 * @param call
	 * @throws InvalidOperationException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws OpenXML4JException
	 * @throws SAXException
	 */
	void process(File file, CallBack call) throws InvalidOperationException, InvalidFormatException, IOException, OpenXML4JException, SAXException;

}