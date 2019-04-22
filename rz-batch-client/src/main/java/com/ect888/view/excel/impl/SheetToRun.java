package com.ect888.view.excel.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.view.CallBack;
import com.ect888.bus.view.impl.MyInputExcelRowColData;

import lombok.Setter;
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
@Setter
@Slf4j
public class SheetToRun implements SheetContentsHandler {

    private int currentRow = -1;
    private int currentCol = -1;
    
    /**
     * 本行中前一个列数据
     * 
     * 对于excel尾部行为空数据的，此列数据可能为null
     */
    private MyInputExcelRowColData beforeMyRowColData;
    
	/**
	 * 一行数据
	 */
	private Collection<MyInputExcelRowColData> currentRowData;

	private CallBack worker;
	
	@Override
	public void startRow(int rowNum) {
		currentRowData = new ArrayList<MyInputExcelRowColData>();
		beforeMyRowColData=null;
		
        currentRow = rowNum;
        currentCol = -1;
	}

	@Override
	public void endRow(int rowNum) {
		if(null!=beforeMyRowColData)//增加健壮性，对于excel尾部行为空数据的，此列数据可能为null
			beforeMyRowColData.setColEndIndexExcluded(-1);//最后一个合并单元格无法获知结束列，设置为-1表示此合并单元格开始列的列号后全部算进
		
		if(!currentRowData.isEmpty()) {//空行不处理
			try {
				log.info(rowNum+" to process "+JSON.toJSONString(currentRowData));
				worker.process(rowNum,currentRowData);
			}catch(RuntimeException e) {
				log.error(rowNum+"行处理出现异常，忽略本行。小程序继续",e);
			}
		}else {
			log.warn(rowNum+"行为空行，忽略本行。小程序继续");
		}
		
	}

	@Override
	public void cell(String cellReference, String formattedValue, XSSFComment comment) {

		// gracefully handle missing CellRef here in a similar way as XSSFCell does
        if(cellReference == null) {
        	log.warn("cellReference == null");
            cellReference = new CellAddress(currentRow, currentCol).formatAsString();
        }

        CellReference ref=new CellReference(cellReference);        
        int thisCol = ref.getCol();
        
//        // Did we miss any cells? 会忽略空单元格，因此，主动补齐中间数据，注：最后一列为空单元格的不支持
//        //合并单元格又怎么算呢？
//        int missedCols = thisCol - currentCol - 1;
//       
//        for (int i = 0; i < missedCols; i++) {
//        	
//        	currentCol++;
//        	
//            if(null!=beforeMyRowColData) {
//            	beforeMyRowColData.setColEndIndexExcluded(currentCol);
//            }
//        	
//        	MyInputExcelRowColData myRow=new MyInputExcelRowColData();
//        	myRow.setValue("");//空字符串
//        	myRow.setColStartIndexIncluded(currentCol);
//            myRow.setRowIndex(currentRow);
//        	currentRowData.add(myRow);
//        	
//    		beforeMyRowColData=myRow;
//        }
//        log.info("thisCol="+thisCol+",missedCols="+missedCols+",currentCol="+currentCol);
       
        if(null!=beforeMyRowColData) {
        	beforeMyRowColData.setColEndIndexExcluded(thisCol);
        }

        MyInputExcelRowColData myRow=new MyInputExcelRowColData();
        
        if(null!=formattedValue)
        	formattedValue=formattedValue.trim();
        
        myRow.setValue(formattedValue);
        myRow.setColStartIndexIncluded(thisCol);
        myRow.setRowIndex(currentRow);
        
		currentRowData.add(myRow);
		
		currentCol = thisCol;
		beforeMyRowColData=myRow;
		
	}
}