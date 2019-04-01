package com.ect888.bus.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.bouncycastle.util.encoders.Base64;

import com.ect888.bus.FunctionCommon;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import com.ect888.util.AES;
import com.ect888.util.SignatureUtil;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 不良信息异步
 * 
 * @author fanyj
 *
 */
public class FunctionCommonImpl  implements FunctionCommon{
	
	private Log log = LogFactory.getLog(FunctionCommonImpl.class);
	
	private FunctionCommonImpl() {
		
	}
	
	private static class Holder{
		public static final FunctionCommonImpl instance=new FunctionCommonImpl();
	}
	
	public static FunctionCommonImpl getInstance() {
		return Holder.instance;
	}
	
	/**
	 * 
	 * 拼凑post的报文
	 * 
	 * 1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
	 * 2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 * 3 toPicBase64_开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 * 4 toUrl_toBase64_开头的，字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数；
	 * 5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
	 * 
	 * @param ptyKey
	 * @param params
	 * @param sign
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private Map<String, String> toPost(String ptyKey,Map<String,String> params,String sign) throws UnsupportedEncodingException {
		//业务参数		
		Map<String, String>  map2Post = new HashMap<String, String>();
		
		for(String k:params.keySet()) {
		
			String v=params.get(k);
			
			if(k.startsWith(TO_SIGN_HEAD)) {//1 toSign_开头的
				
				String key=k.replaceFirst(TO_SIGN_HEAD, "");
				map2Post.put(key, v);
				
			}else if(k.startsWith(TO_AES_TO_URL_TO_BASE64_HEAD)) {//2 toAes_toUrl_toBase64_开头的
				//进行以下处理，步骤为：[a]，用会话密钥加密(AES加密方法);[b].URLEncoder.encode（[a]中加密串）;[c],base64（[b]中字符串）
				String v2aes=AES.encrypt(v, ENCODE_UTF8,ptyKey);
				String v2Base64UrlEnAes = Base64.toBase64String((URLEncoder.encode(v2aes, ENCODE_UTF8)).getBytes(ENCODE_UTF8));
				
				String key=k.replaceFirst(TO_AES_TO_URL_TO_BASE64_HEAD, "");
				map2Post.put(key, v2Base64UrlEnAes);
				
			}else if(k.startsWith(TO_PIC_BASE64_HEAD)) {//3 toPicBase64_开头的
				//并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
				
				String key=k.replaceFirst(TO_PIC_BASE64_HEAD, "");
				
				byte[] bytes=readPic4Bytes(new File(v));
				
				String base64=Base64.toBase64String(bytes);
				
				map2Post.put(key, base64);
			}else if(k.startsWith(TO_URL_TO_BASE64_HEAD)) {//4  toUrl_toBase64_开头的
				//以url编码再base64编码形式post发送请求的参数；
				String key=k.replaceFirst(TO_URL_TO_BASE64_HEAD, "");
				
				String urlEn=URLEncoder.encode(v, ENCODE_UTF8);
				
				String base64=Base64.toBase64String(urlEn.getBytes(ENCODE_UTF8));
				
				map2Post.put(key, base64);
				
			}else {//5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
				map2Post.put(k, v);
			}
			
		}
		
		map2Post.put("sign", sign);
		
		return map2Post;
	}
	
	private byte[] readPic4Bytes(File picFile) {
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		try {
			Thumbnails.of(picFile).scale(1).toOutputStream(os);
		} catch (IOException e) {
			log.error("",e);
		}
		return os.toByteArray();
	}
	
	/**
	 * 
	 * 生成防篡改签名sign
	 * 
	 * 1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
	 * 2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 * 
	 * @param ptyKey
	 * @param params
	 * @return
	 */
	private String toSign(String ptyKey,Map<String,String> params) {
		
		Map<String,String> toSignMap=new HashMap<String,String>();
		
		for(String k:params.keySet()) {
			
			String v=params.get(k);
			
			if(k.startsWith(TO_SIGN_HEAD)) {//1 toSign_开头的
				
				String key=k.replaceFirst(TO_SIGN_HEAD, "");
				toSignMap.put(key, v);
				
			}else if(k.startsWith(TO_AES_TO_URL_TO_BASE64_HEAD)) {//2 toAes_toUrl_toBase64_开头的
				
				String v2aes=AES.encrypt(v,ENCODE_UTF8,ptyKey);//即使值为空也需要加密处理
				
				String key=k.replaceFirst(TO_AES_TO_URL_TO_BASE64_HEAD, "");
				toSignMap.put(key, v2aes);
				
			}else {
				log.debug("ommit k="+k);
			}
			
		}
		
		
		return SignatureUtil.signature(toSignMap, ptyKey);
	}
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	@Override
	public String invoke(Map<String,String> params){
		
		String ptyKey=config.getPtyKey();
		
		String sign=toSign(ptyKey, params);
		
		Map<String, String> map2Post=null;
		try {
			map2Post = toPost(ptyKey, params, sign);
		} catch (UnsupportedEncodingException e) {
			log.error("",e);
		}

		//发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
		String result="";
		try {
			result = client.post(config.getUrl(), map2Post);
		} catch (ClientProtocolException e) {
			log.error("",e);
		} catch (IOException e) {
			log.error("",e);
		}
		log.info("result="+result);
		
		return result;
	}
}
