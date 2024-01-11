package com.ect888.bus;

import java.util.Map;

public interface FunctionCommon {
	
	/**
	 * AES加密字符编码
	 */
	public static final String ENCODE_UTF8="utf-8";
	
	/**
	 *  toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数
	 */
	public static final String TO_SIGN_HEAD="toSign_";
	
	/**
	 * toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 */
	public static final String TO_AES_TO_URL_TO_BASE64_HEAD="toAes_toUrl_toBase64_";

	public static final String TO_AES_DATA_HEAD ="toAes_data_";
	
	/**
	 * toPicBase64_开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 */
	public static final String TO_PIC_BASE64_HEAD="toPicBase64_";

	public static final String TO_AES_PIC_BASE64_HEAD="toAesPicBase64_";


	
	/**
	 * toPicBase64_开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 */
	public static final String TO_VIDEO_BASE64_HEAD="toVideoBase64_";
	
	/**
	 * toUrl_toBase64_开头的，字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数；
	 */
	public static final String TO_URL_TO_BASE64_HEAD="toUrl_toBase64_";

	/**
	 * 
	 * 根据业务请求入参params（是字段名到字段值的映射;字段名的前缀符合http post上送和加密加签规则），http post请求服务端，返回结果报文
	 * 
	 * 注：业务请求入参字段名title规则：
1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
3 toPicBase64__开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
4 toUrl_toBase64_开头：字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数
5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；

大小写敏感
	 * 
	 * @param params 业务请求入参：是字段名到字段值的映射;字段名的前缀符合http post上送和加密加签规则
	 * @return 响应结果，报文字符串形式
	 */
	String invoke(Map<String, String> params);
	String invoke(Map<String, String> params,Map<String,String> header);



}
