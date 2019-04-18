package com.ect888.util;


import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.util.encoders.Base64;


/**
 * 
 * ## 具体过程

指的是如下整个过程，输入为待加密的字符串data，会话秘钥字符串key，输出为字符串Y：

1. 字符串data以utf8编码方式解码为byte数组byteContent；

2. 会话秘钥字符串key以utf8编码方式解码为byte数组password；

   通过SHA1PRNG算法对password进行了又一次加密得到byte数组enCodeFormat。

   注：只要password一样，每次生成的数组都是一样的，所以可以用来做加密解密的enCodeFormat

3. 对byteContent使用aes算法和enCodeFormat加密得到byte数组bs；

   其中，AES，128位，密码模式ECB，填充类型PKCS5Padding或者PKCS7Padding。

   注：ECB模式不需要初始化向量iv。

4. 对bs进行base64得到密文字符串Y。
 * 
 * ## SHA1PRNG算法说明：SHA1PRNG和SHA1的关系

### 算法细节描述

SHA1PRNG等价于(输入为字符串key，输出为byte数组enCodeFormat的版本)，对输入字符串key：

1. 字符串key以utf8解码为byte，得到byte数组password；
2. 使用sha1（输入输出都为byte数组的版本），对byte数组password处理，得到byte数组sha1FirstBytes；
3. 使用sha1（输入输出都为byte数组的版本），对byte数组sha1FirstBytes处理，得到byte数组sha1SecondBytes；
4. 截取byte数组sha1SecondBytes的前16个元素，得到结果byte数组enCodeFormat。enCodeFormat共是128bits。

### java示例
 * 		//1 字符串key以utf8解码为byte，得到byte数组password；
	    byte[] password=key.getBytes("utf8");
	    
	    //2 使用sha1（输入输出都为byte数组的版本），对byte数组password处理，得到byte数组sha1FirstBytes；
	    byte[] sha1FirstBytes=DigestUtils.sha1(password);
	    //3 使用sha1（输入输出都为byte数组的版本），对byte数组sha1FirstBytes处理，得到byte数组sha1SecondBytes；
	    byte[] sha1SecondBytes = DigestUtils.sha1(sha1FirstBytes);
	    
	    //4 截取byte数组sha1SecondBytes的前16个元素，得到结果byte数组enCodeFormat。enCodeFormat共是128bits。
	    byte[]enCodeFormat=Arrays.copyOf(sha1SecondBytes, 16);
	    
	    //以hex显示byte数组
	    System.out.println("enCodeFormat hex="+Hex.encodeHexString(enCodeFormat));
	    //以base64显示byte数组
	    System.out.println("enCodeFormat base64="+Base64.toBase64String(enCodeFormat));
 * 
 * @author fanyj
 *
 */
public class AES_SHA1PRNG{
	
	private static Log log = LogFactory.getLog(AES_SHA1PRNG.class);
	
    public static String mode = "AES/ECB/PKCS5Padding";
    
    /**
     * 
     * aes加密
     * 
     * 2 通过SHA1PRNG算法对password进行了又一次加密得到byte数组enCodeFormat。注：只要password一样，每次生成的数组都是一样的，所以可以用来做加密解密的enCodeFormat
     * 3 对byteContent使用aes算法和enCodeFormat加密得到byte数组bs；
     * 其中，AES，128位，密码模式ECB，填充类型PKCS5Padding或者PKCS7Padding。注：ECB模式不需要初始化向量iv。
     * 
     * @param byteContent
     * @param password
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(final byte[] byteContent, final byte[] password) throws Exception {
        final KeyGenerator kgen = KeyGenerator.getInstance("AES");
        final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password);
        kgen.init(128, secureRandom);
        final SecretKey secretKey = kgen.generateKey();
        final byte[] enCodeFormat = secretKey.getEncoded();
        
        log.info("C#="+Base64.toBase64String(enCodeFormat));//用于java的aes密钥转换为可用于C#示例AES加密的密钥
        
        final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        final Cipher cipher = Cipher.getInstance(mode);
        cipher.init(1, key);
        final byte[] result = cipher.doFinal(byteContent);
        return result;
    }
    
    
    /**
     * 
     * 
     * “AES+SHA1PRNG加密”指的是如下整个过程，输入为待加密的字符串data，会话秘钥字符串key，输出为字符串Y：
     * 1 字符串data以utf8编码方式解码为byte数组byteContent；
     * 2 会话秘钥字符串key以utf8编码方式解码为byte数组password；
     *  通过SHA1PRNG算法对password进行了又一次加密得到byte数组enCodeFormat。注：只要password一样，每次生成的数组都是一样的，所以可以用来做加密解密的enCodeFormat
     * 3 对byteContent使用aes算法和enCodeFormat加密得到byte数组bs；
     * 其中，AES，128位，密码模式ECB，填充类型PKCS5Padding或者PKCS7Padding。注：ECB模式不需要初始化向量iv。
     * 4 对bs进行base64得到密文字符串Y。
     * 
     * @param data
     * @param charsetName
     * @param key
     * @return
     */
    public static final String encrypt(final String data, final String charsetName,final String key) {
    	log.info("data="+data+",charsetName="+charsetName+",key="+key);
        try {
        	byte[] byteContent=data.getBytes(charsetName);//1 字符串data以utf8编码方式解码为byte数组byteContent；
        	
        	/* 2 会话秘钥字符串key以utf8编码方式解码为byte数组password；
            *  通过SHA1PRNG算法对password进行了又一次加密得到byte数组enCodeFormat。注：只要password一样，每次生成的数组都是一样的，所以可以用来做加密解密的enCodeFormat
            * 3 对A使用aes算法和enCodeFormat加密得到byte数组bs；
            * 其中，AES，128位，密码模式ECB，填充类型PKCS5Padding或者PKCS7Padding。注：ECB模式不需要初始化向量iv。*/
        	byte[] password= key.getBytes(charsetName);
        	byte [] bs=encrypt(byteContent,password);
        	
            String re=Base64.toBase64String(bs);//4 对bs进行base64得到密文字符串Y。
            log.info("aes re="+re);
            return re;
        } catch (Exception e) {
        	log.error("aes加密失败",e);
            return null;
        }
    }
    
 }
