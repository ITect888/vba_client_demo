package com.ect888.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * 机构跑批响应结果的提取  
 * 
 * @author fanyj
 *
 */
@Component
@Data
@ConfigurationProperties(prefix = "resp-extract")
public class RespExtractConfig {
	
    /**
     * 从响应结果中提取的字段及其对应输出中文title
     */
    private List<ChiField>   field2chiList=new ArrayList<>();
    
    /**
     *提取的字段中，字段值需要中文映射的   
     */
    private List<FieldValueChi>   field2value2chiList=new ArrayList<>();
}
