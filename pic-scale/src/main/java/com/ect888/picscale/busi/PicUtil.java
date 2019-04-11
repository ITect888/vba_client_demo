package com.ect888.picscale.busi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Component
@Slf4j
public class PicUtil {
	
	/**
	 * 
	 * 尝试将图片base64字符串videopic缩放到targetSize以下，最多尝试tryTimes次
	 * 
	 * @param targetSize 压缩图片目标大小，单位B
	 * @param tryTimes 最大尝试次数
	 * @return
	 */
	public byte[] compressPic(File input,final int targetSize,final int tryTimes){
		int i=0;
		byte[] picTemp=null;
		try{
			ByteArrayOutputStream bo=new ByteArrayOutputStream();
			Thumbnails.of(input).scale(1).toOutputStream(bo);
			picTemp=bo.toByteArray();
			
			while(picTemp.length > targetSize && i<tryTimes){
				double scale=Math.sqrt(((double)targetSize)/picTemp.length);
				if(scale>0.9) {
					scale = 0.9;
				}
				log.info("第"+i+"次缩放,scale="+scale+ ".缩放前图片bytes长度"+picTemp.length);
				
				bo=new ByteArrayOutputStream();
				Thumbnails.of(new ByteArrayInputStream(picTemp)).scale(scale).toOutputStream(bo);
				picTemp=null;//大对象加速回收				
				picTemp = bo.toByteArray();
				log.info("第"+i+"次缩放,scale="+scale+ ".缩放后图片bytes长度"+picTemp.length);
				bo.close();
				bo=null;//大对象加速回收
				i += 1;
			}
			
		}catch(Exception e){
			log.error("缩放出错，使用缩放前值，仍然继续处理",e);
		}finally {
			log.info("缩放完成,循环次数"+i+",缩放后图片bytes长度"+picTemp.length);
		}
		return picTemp;
	}
}
