package com.ect888.bus.view;

import java.util.Collection;
import java.util.List;

import com.ect888.bus.view.impl.MyInputExcelRowColData;
import com.ect888.controller.Controller;

/**
 * 
 * 逐行读入的回调输入解析：
 * 1 处理每行读入数据；交给控制层
 * 2 得到输出title；
 * 3 设置控制层
 *
 * 
 * @author fanyj
 *
 */
public interface CallBack {
	/**
	 * 
	 * 处理每行读入数据；交给控制层
	 * 
	 * @param rowNum
	 * @param row
	 */
	void process(int rowNum,Collection<MyInputExcelRowColData> row);
	
	/**
	 * 
	 * 得到输出title
	 * 
	 * @return
	 */
	List<List<String>> getOutPutTitle();
	
	/**
	 * 
	 * 设置控制层
	 * 
	 * @param controller
	 */
	void setController(Controller controller);
}
