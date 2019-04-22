package com.ect888.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * 针对机构跑批入参_模板的title到自动验证小程序入参_模板字段名的转换和账户接口号配置
 * 
 * @author fanyj
 *
 */
@Component
@Data
@ConfigurationProperties(prefix = "title-trans")
public class TitleTransConfig {
	
	/**
	 * 是否调用N次102结果查询
	 * one-plus-n
	 * boolean型不能使用如isOonePlusN这样is开通的，getter setter会读取不到
	 */
	private boolean onePlusN;
	
	/**
	 * 机构账号
	 */
	private String ptyacct;          		   
	/**
	 * 机构号
	 */
	private String ptycd;                        
	/**
	 * 会话密钥
	 */
	private String ptyKey;
	
	/**
	 * 接口功能号
	 */
	private String funcNo;
	
    /**
     * 中文title换为字段名的映射
     */
    private List<ChiField> chi2fieldList=new ArrayList<>();
    
    /**
     * 接口必填字段输入参数中， 机构跑批入参_模板没有，取配置的映射
     */
    private List<ChiField> fieldOmitList=new ArrayList<>();
}
