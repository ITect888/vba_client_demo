package com.ect888.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 描述: SHA-512 摘要算法实现类
 */
public class SHA512 {
	
	private static Log log = LogFactory.getLog(SHA512.class);
	
	/**
	 * 
	 * source字节数组，SHA512签名的字符串形式
	 * 
	 * @param source 待签名的入参
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static String getSHA512(byte[] source) throws NoSuchAlgorithmException {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-512");
		md.update(source);
		byte tmp[] = md.digest(); // SHA-512 的计算结果是一个 64 位的长整数

		return new String(Hex.encodeHex(tmp)); // 换后的结果转换为字符串

	}

	/**
	 * 入参inbuf以UTF-8编码，然后SHA512签名的字符串形式
	 * 
	 * @param inbuf 待签名的入参
	 * @return
	 */
	public static String getSHA512ofStr(String inbuf) {
		String s = "";
		try {
			s = getSHA512(inbuf.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			log.error("SHA-512异常", e);
		} catch (UnsupportedEncodingException e) {
			log.error("上传数据转换异常", e);
		}
		return s;
	}

}
