package com.ect888.view.excel.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.model.Styles;
import org.apache.poi.xssf.model.StylesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.ect888.bus.view.CallBack;
import com.ect888.view.excel.ExcelReader;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户模式：也就是poi下的usermodel有关包，它对用户友好，有统一的接口在ss包下，但是它是把整个文件读取到内存中的，
对于大量数据很容易内存溢出，所以只能用来处理相对较小量的数据；
事件模式：在poi下的eventusermodel包下，相对来说实现比较复杂，但是它处理速度快，占用内存少，可以用来处理海量的Excel数据。
 */
@Component
@Slf4j
public class Excel2007Reader implements ExcelReader{

	@Override
	public void process(File file,CallBack call) throws InvalidOperationException, IOException, OpenXML4JException, SAXException {
	     if (!file.exists()) {
	         String msg="Not found or not a file: " + file.getPath();
	         throw new IllegalArgumentException(msg);
	     }

	     // The package open is instantaneous, as it should be.
	     try (OPCPackage p = OPCPackage.open(file.getPath(), PackageAccess.READ)) {
	    	 process(call,p);
	     }
	}

	 /**
	  * Initiates the processing of the XLS workbook file to CSV.
	  * @return sheet 数目
	  * @throws IOException If reading the data from the package fails.
	  * @throws SAXException if parsing the XML data fails.
	  */
	 private int process(CallBack call,OPCPackage xlsxPackage) throws IOException, OpenXML4JException, SAXException {
	     ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(xlsxPackage);
	     XSSFReader xssfReader = new XSSFReader(xlsxPackage);
	     StylesTable styles = xssfReader.getStylesTable();
	     XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
	     int index = 0;//sheet 数目
	     while (iter.hasNext()) {//读取多个sheet
	    	 
	         if(index>0) {
	        	 log.error("只支持处理一个sheet，其他sheet忽略,index="+index);
	        	 break;
	         }
	    	 
	         try (InputStream stream = iter.next()) {
	             String sheetName = iter.getSheetName();
	             log.info(sheetName + " [index=" + index + "]:");
	             SheetToRun sheetToRun=applicationContext.getBean(SheetToRun.class);
	             sheetToRun.setWorker(call);
	             processSheet(styles, strings,sheetToRun , stream);
	         }
	         
	         ++index;
	         
	     }
	     
	     return index;
	 }
	 
	@Autowired
    private ApplicationContext applicationContext;
		
	 /**
	  * Parses and shows the content of one sheet
	  * using the specified styles and shared-strings tables.
	  *
	  * @param styles The table of styles that may be referenced by cells in the sheet
	  * @param strings The table of strings that may be referenced by cells in the sheet
	  * @param sheetInputStream The stream to read the sheet-data from.
	  
	  * @exception java.io.IOException An IO exception from the parser,
	  *            possibly from a byte stream or character stream
	  *            supplied by the application.
	  * @throws SAXException if parsing the XML data fails.
	  */
	 private void processSheet(
	         Styles styles,
	         SharedStrings strings,
	         SheetContentsHandler sheetHandler, 
	         InputStream sheetInputStream) throws IOException, SAXException {
	     DataFormatter formatter = new DataFormatter();
	     InputSource sheetSource = new InputSource(sheetInputStream);
	     try {
	         XMLReader sheetParser = SAXHelper.newXMLReader();
	         ContentHandler handler = new XSSFSheetXMLHandler(
	               styles, null, strings, sheetHandler, formatter, false);
	         sheetParser.setContentHandler(handler);
	         sheetParser.parse(sheetSource);
	      } catch(ParserConfigurationException e) {
	         throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
	      }
	 }
}