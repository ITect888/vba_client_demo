package com.ect888.bus;

import java.util.Map;

import com.ect888.bus.impl.ChangelessOutput;

/**
 * 
 * VBA接口通用调用
 * 
 * @author fanyj
 *
 */
public interface FunctionCommon {
	
	/**
	 * spec_则是默认固定值:SPEC_MAP有则使用，否则为0
	 */
	public static final String SPEC_STR="spec_";
	
	/**
	 * spec_time是程序自动取当前时间
	 */
	public static final String SPEC_TIME_STR="spec_time";
	
	/**
	 * AES加密字符编码
	 */
	public static final String ENCODE_UTF8="utf-8";
	
	/**
	 * toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数
	 */
	public static final String TO_SIGN_HEAD="toSign_";
	
	/**
	 * toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 */
	public static final String TO_AES_TO_URL_TO_BASE64_HEAD="toAes_toUrl_toBase64_";
	
	/**
	 * toPicBase64__开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 */
	public static final String TO_PIC_BASE64="toPicBase64_";
	
	/**
	 * toUrl_toBase64_开头的，字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数；
	 */
	public static final String TO_URL_TO_BASE64_HEAD="toUrl_toBase64_";

	/**
	 * 
	 * 调用VBA接口
	 * 
	 * 一业务请求入参title规则：
1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
3 toPicBase64__开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
4 toUrl_toBase64_开头：字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数
5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；

二：业务请求入参值规则：
1 spec_则是默认固定值:SPEC_MAP有则使用，否则为0
2 spec_time是程序自动取当前时间
3 否则，填写什么值就使用什么值

大小写敏感
	 * 
	 * 
	 * @param ptyKey 会话秘钥
	 * @param params 字段名到字段值的映射，业务请求入参
	 * @return 响应结果，包括响应流水号，报文字符串形式，响应时间差和时间戳
	 */
	ChangelessOutput invoke(String ptyKey, Map<String, String> params);

}
