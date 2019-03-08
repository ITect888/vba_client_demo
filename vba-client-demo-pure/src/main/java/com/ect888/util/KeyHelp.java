package com.ect888.util;

import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * @描述 公钥加密
 * @author tiger
 *
 */
public class KeyHelp {

	public static final String KEY_ALGORTHM = "RSA";

	public static String getStrByPublic(String publickey, String data) throws Exception {
		byte[] encryData = encryptByPublicKey(data.getBytes(), publickey);
		String reData = URLEncoder.encode(Base64.encodeBytes(encryData, Base64.DONT_BREAK_LINES), "utf-8");
		return Base64.encodeBytes(reData.getBytes(), Base64.DONT_BREAK_LINES);
	}

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.decode(key);
	}

	/**
	 * 用公钥加密
	 * 
	 * @param data 加密数据
	 * @param key  密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
		// 对公钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取公钥
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		return cipher.doFinal(data);
	}
}
