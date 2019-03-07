package com.ect888.main;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import sun.misc.BASE64Encoder;

/**
 * 
 * 将VBA返回的用于java的会话密钥转换为可用于C#示例AES加密的回话秘钥
 * 
 * 
 * @author fanyj
 *
 */
public class Main {
	

	public static void main(String[] args) throws NoSuchAlgorithmException {
		if(args.length<1){
			System.out.println("need one arg of ptyKey for java!");
			return;
		}
		
		String transferKey =args[0];
		System.out.println("input ptyKey for java is "+transferKey);
		
		KeyGenerator kgen = KeyGenerator.getInstance("AES"); 
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG"); 
		random.setSeed(transferKey.getBytes()); 
		kgen.init(128, random); 
		SecretKey secretKey = kgen.generateKey(); 
		byte[] enCodeFormat = secretKey.getEncoded(); 
		BASE64Encoder coder = new BASE64Encoder(); 
		String result=coder.encode(enCodeFormat);

		System.out.println("ptyKey4CSharp is "+result);
	}

}
