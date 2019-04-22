package com.ect888.bus.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ect888.bus.FunctionCommon;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import com.ect888.util.AES_SHA1PRNG;
import com.ect888.util.SignatureUtil;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

/**
 * VBA接口通用调用
 * 只调用一次funcNo
 * 
 * @author fanyj
 *
 */
@Slf4j
@Service
public class FunctionCommonImpl  implements FunctionCommon{
	
	/**
	 * 
	 * 拼凑post的报文
	 * 
	 * 1 toSign_开头的，字段名为title去掉toSign_开头后的值，字段值是以原文形式参加签名，也以原文形式post发送请求的参数；
	 * 2 toAes_toUrl_toBase64_开头的，字段名为title去掉toAes_toUrl_toBase64_开头后的值，字段值是以aes密文形式参加签名，也以aes加密再url编码再base64编码形式post发送请求的参数；
	 * 3 toPicBase64_开头的，字段名为title去掉toPicBase64_开头后的值，字段值不参加签名，并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
	 * 4 toUrl_toBase64_开头：字段名为title去掉toUrl_toBase64_开头后的值，字段值不参加签名，并以url编码再base64编码形式post发送请求的参数
	 * 5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
	 * 
	 * @param ptyKey
	 * @param params
	 * @param sign
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private Map<String, String> toPost(String ptyKey,Map<String,String> params,String sign){
		//业务参数		
		Map<String, String>  map2Post = new HashMap<String, String>();
		
		params.keySet().stream().forEach(k->{
			
			String v=params.get(k);
			
			if(k.startsWith(TO_SIGN_HEAD)) {//1 toSign_开头的
				
				String key=k.replaceFirst(TO_SIGN_HEAD, "");
				map2Post.put(key, v);
				
			}else if(k.startsWith(TO_AES_TO_URL_TO_BASE64_HEAD)) {//2 toAes_toUrl_toBase64_开头的
				//进行以下处理，步骤为：[a]，用会话密钥加密(AES加密方法);[b].URLEncoder.encode（[a]中加密串）;[c],base64（[b]中字符串）
				String key=k.replaceFirst(TO_AES_TO_URL_TO_BASE64_HEAD, "");
				String v2aes=AES_SHA1PRNG.encrypt(v, ENCODE_UTF8,ptyKey);
				String v2Base64UrlEnAes=null;
				try {
					String urlEn=URLEncoder.encode(v2aes, ENCODE_UTF8);
					
					v2Base64UrlEnAes = Base64.getEncoder().encodeToString(urlEn.getBytes(ENCODE_UTF8));
				} catch (UnsupportedEncodingException e) {
					log.error(key+","+v2aes+" URLEncoder.encode getBytes with "+ENCODE_UTF8,e);
				}
				
				map2Post.put(key, v2Base64UrlEnAes);
				
			}else if(k.startsWith(TO_PIC_BASE64)) {//3 toPicBase64_开头的
				//并以之为文件路径读入图片base64编码后的字符串post发送请求的参数；
				
				String key=k.replaceFirst(TO_PIC_BASE64, "");
				
				byte[] bytes=readPic4Bytes(new File(v));
				
				String base64=Base64.getEncoder().encodeToString(bytes);
				
				map2Post.put(key, base64);
			}else if(k.startsWith(TO_URL_TO_BASE64_HEAD)) {//4  toUrl_toBase64_开头的
				//以url编码再base64编码形式post发送请求的参数；
				String key=k.replaceFirst(TO_URL_TO_BASE64_HEAD, "");
				
				String base64=null;
				try {
					String urlEn=URLEncoder.encode(v, ENCODE_UTF8);
				
					base64=Base64.getEncoder().encodeToString(urlEn.getBytes(ENCODE_UTF8));
				} catch (UnsupportedEncodingException e) {
					log.error(key+","+v+" URLEncoder.encode getBytes with "+ENCODE_UTF8,e);
				}
				
				map2Post.put(key, base64);
				
			}else {//5 否则，字段名为title，字段值不参加签名，并以原文形式post发送请求的参数；
				map2Post.put(k, v);
			}
			
		});
		
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
		
		params.keySet().stream().forEach(k->{
			
			String v=params.get(k);
			
			if(null==k) {
				String msg="参数名为null，其值为"+v+".请检查模式和输入excel模板是否不一致";
				log.error(msg);
				throw new IllegalArgumentException(msg);
			}
			
			if(k.startsWith(TO_SIGN_HEAD)) {//1 toSign_开头的
				
				String key=k.replaceFirst(TO_SIGN_HEAD, "");
				toSignMap.put(key, v);
				
			}else if(k.startsWith(TO_AES_TO_URL_TO_BASE64_HEAD)) {//2 toAes_toUrl_toBase64_开头的
				
				String v2aes=AES_SHA1PRNG.encrypt(v,ENCODE_UTF8,ptyKey);//即使值为空也需要加密处理
				
				String key=k.replaceFirst(TO_AES_TO_URL_TO_BASE64_HEAD, "");
				toSignMap.put(key, v2aes);
				
			}else {
				log.debug("ommit k="+k);
			}
			
		});
		
		
		return SignatureUtil.signature(toSignMap, ptyKey);
	}
	
	
	/**
	 * 
	 * 二：业务请求入参值规则：
1 spec_则是默认固定值:SPEC_MAP有则使用，否则为0
2 spec_time是程序自动取当前时间
3 否则，填写什么值就使用什么值

大小写敏感
	 * 
	 * @param params
	 */
	private void trySpecValue(Map<String,String> params) {
		params.keySet().forEach(k->{
			if(null==k) {
				return;
			}
			String v=params.get(k);
			
			if(SPEC_STR.equals(v)) {//1 spec_则是默认固定值:SPEC_MAP有则使用，否则为0
				
				String nv="0";
				if(SPEC_MAP.containsKey(k)) {
					nv=SPEC_MAP.get(k);
				}
				
				params.put(k, nv);
				return;
			}
			
			if(SPEC_TIME_STR.equals(v)) {//1 spec_time是程序自动取当前时间
				String nv=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
				params.put(k, nv);
				return;
			}
			
		});
		
	}
	
	public static final  Map<String,String> SPEC_MAP=new HashMap<String,String>() ;
	static {
		SPEC_MAP.put("sourcechnl","0");
		SPEC_MAP.put(TO_SIGN_HEAD+"sourcechnl","0");
		SPEC_MAP.put(TO_AES_TO_URL_TO_BASE64_HEAD+"sourcechnl","0");
		SPEC_MAP.put(TO_PIC_BASE64+"sourcechnl","0");
	}
	
	/**
	 * json结果result的解析并处理
	 * 
	 * @param result 响应报文
	 * @param ct 响应时间戳和时间差
	 * @return
	 */
	private ChangelessOutput processResult(String result,ConsumingTime ct) {
		ChangelessOutput out=new ChangelessOutput();
		
		if(null==result) {
			log.error("结果为null");
			return out;
		}
		
		out.setConsumingTime(ct);//有响应报文，才有响应时间戳和时间差
		
		out.setResults(result);
		
		JSONObject common=JSON.parseObject(result);
		if("0".equals(common.getString("error_no"))) {
			
			JSONArray arr=common.getJSONArray("results");
			if(null==arr||arr.isEmpty()) {
				log.warn("JSONArray arr=common.getJSONArray(\"results\") while null==arr||arr.isEmpty() when error_no=0");
				return out;
			}
			
			String seq=arr.getJSONObject(0).getString("sysSeqNb");//有些接口返回sysSeqNb
			if(!StringUtils.hasText(seq)) {//有些接口返回sysseqnb
				seq=arr.getJSONObject(0).getString("sysseqnb");
			}
			
			out.setSysseqnb(seq);
		}
		
		return out;
		
	}
	
	@Autowired
	private Config config;
	
	@Autowired
	private PoolClient client;
	
	@Override
	public ChangelessOutput invoke(String ptyKey,Map<String,String> params){
		
		trySpecValue(params);
		
		String sign=toSign(ptyKey, params);
		
		Map<String, String> map2Post= toPost(ptyKey, params, sign);

		//发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
		String result="";
		ConsumingTime ct=new ConsumingTime();
		LocalDateTime posttm=LocalDateTime.now();
		ct.setPosttm(posttm);
		log.info("post "+config.getUrl());
		try {
			result = client.post(config.getUrl(), map2Post);
		} catch (ClientProtocolException e) {
			log.error("",e);
		} catch (IOException e) {
			log.error("",e);
		}finally {
			LocalDateTime resptm=LocalDateTime.now();
			ct.setResptm(resptm);
		}
		log.info("result="+result);
		
		ZoneOffset zoneOffset=OffsetDateTime.now().getOffset();
		long timeDiffMills=ct.getResptm().toInstant(zoneOffset).toEpochMilli()
				-ct.getPosttm().toInstant(zoneOffset).toEpochMilli();
		ct.setTimeDiffMills(timeDiffMills);//时差，单位毫秒：收到交易返回结果时间-交易发起时间
			
		//解析返回数据并处理
		return processResult(result,ct);
	}
}
