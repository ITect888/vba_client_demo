package com.thinkive.base;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SignatureUtil{
	
	private static Log log = LogFactory.getLog(SignatureUtil.class);
	
	/**
	* SHA-512摘要
	* 按照params映射的主键字典序排列拼接成字符串，最后追加会话秘钥secret
	* 
	 * @param params 入参映射，主键是字段名，值为字段值
	 * @param secret 会话密钥
	 * @return
	 */
	public static String signature(Map<String, String> params, String secret){
		String result = null;
		StringBuffer orgin = getSignParam(params);
		if (orgin == null)
			return result;
		orgin.append(secret);
		try{
			log.info("orgin=" + orgin.toString());
			result = SHA512.getSHA512ofStr(orgin.toString());
		}catch (Exception e){
			log.error("SHA-512摘要出错",e);
			throw new java.lang.RuntimeException("sign error !");
		}
		return result;
	}
	
	/**
	 * 
	 * 添加参数的封装方法
	 * 按照params映射的主键字典序排列拼接成字符串
	 * 
	 * params为null则返回null
	 * 
	 * @param params 入参映射
	 * @return
	 */
	private static StringBuffer getSignParam(Map<String, String> params){
		
		if (null==params)
			return null;
		
		StringBuffer sb = new StringBuffer();

		TreeMap<String,String> treeMap=new TreeMap<String,String>();
		treeMap.putAll(params);

		for(String k:treeMap.keySet()) {
			sb.append(k).append(params.get(k));
		}
		
		return sb;
	}
}
