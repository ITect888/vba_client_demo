package com.ect888;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Before;
import org.junit.Test;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 * 图片缩放示例
 * 
 * @author fanyj
 *
 */
public class PicCompressTest {
	
	private static Log log = LogFactory.getLog(PicCompressTest.class);
	
	/**
	 * 缩放最大尝试次数
	 */
	public static final int MAX_TYR = 20;
	/**
	 * 图片字节数组在内存中的大小限制，即压缩图片目标大小，单位B 
	 * 30KB
	 */
	private static final int MAX_PIC_SIZE = 30 * 1024;

	/**
	 * 图片base64字符串形式的大小限制，即压缩图片目标大小，单位B
	 */
	public static final int MAX_PIC_SIZE_BASE64 = MAX_PIC_SIZE * 4 / 3;

	/**
	 * 
	 * 尝试将图片base64字符串videopic缩放到targetSize以下，最多尝试MAX_TYR=20次
	 * 
	 * @param videopic         图片base64字符串
	 * @param targetSizeBase64 图片base64字符串形式的大小限制，即压缩图片目标大小，单位B
	 * @return
	 */
	public static String compressPic(final String videopic, final int targetSizeBase64) {
		return compressPic(videopic, targetSizeBase64, MAX_TYR);
	}

	/**
	 * 
	 * 尝试将图片base64字符串videopic缩放到targetSize以下，最多尝试tryTimes次
	 * 
	 * @param videopic         图片base64字符串
	 * 
	 *                         ImageIO.read()方法读取图片时可能存在不正确处理图片ICC信息的问题，ICC为JPEG图片格式中的一种头部信息，导致渲染图片前景色时蒙上一层红色。
	 *                         BufferedImage bf=ImageIO.read(new
	 *                         ByteArrayInputStream(picTemp)); 故改用Thumbnails
	 * 
	 * @param targetSizeBase64 图片base64字符串形式的大小限制，即压缩图片目标大小，单位B
	 * @param tryTimes         最大尝试次数
	 * @return
	 */
	public static String compressPic(final String videopic, final int targetSizeBase64, final int tryTimes) {

		log.info("现场照大于" + targetSizeBase64 + "，需要进行缩放，缩放前base64字符串长度" + videopic.length());
		int i = 0;
		int targetSize = targetSizeBase64 * 3 / 4;
		String videopic2Use = videopic;
		try {
			byte[] picTemp = Base64.decode(videopic2Use);

			while (picTemp.length > targetSize && i < tryTimes) {
				double scale = Math.sqrt(((double) targetSize) / picTemp.length);
				if (scale > 0.9) {
					scale = 0.9;
				}
				log.info("第" + i + "次缩放,scale=" + scale + ".缩放前图片bytes长度" + picTemp.length);

				ByteArrayOutputStream bo = new ByteArrayOutputStream();
				Thumbnails.of(new ByteArrayInputStream(picTemp)).scale(scale).toOutputStream(bo);
				picTemp = null;// 大对象加速回收
				picTemp = bo.toByteArray();
				
				log.info("第" + i + "次缩放,scale=" + scale + ".缩放后图片bytes长度" + picTemp.length);
				bo.close();
				bo = null;// 大对象加速回收
				i += 1;
			}

			videopic2Use = new String(Base64.encode(picTemp));
		} catch (Exception e) {
			log.error("缩放出错，使用缩放前值，仍然继续处理", e);
			return videopic;
		} finally {
			log.info("缩放完成,循环次数" + i + ",缩放后base64字符串长度" + videopic2Use.length());
		}
		return videopic2Use;
	}

	private byte[] readPic4Bytes(File picFile) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			Thumbnails.of(picFile).scale(1).toOutputStream(os);
		} catch (IOException e) {
			log.error("", e);
		}
		return os.toByteArray();
	}

	static String root=Thread.currentThread().getContextClassLoader().getResource("").getPath()+File.separator;
	
	
	@Test
	public void test() throws IOException {
		int targetSizeBase64=MAX_PIC_SIZE_BASE64;
		log.info("root="+root);
		String path=root+"fanyj.jpg";
		File picFile=new File(path);
		byte[] in=readPic4Bytes(picFile);
		
		String videopic=new String(Base64.encode(in));
		String after=compressPic(videopic, targetSizeBase64);
		byte[] bs=Base64.decode(after);
		
		String out=root+"to"+targetSizeBase64+".jpg";
		log.info("to out="+out);
		try {
			Thumbnails.of(new ByteArrayInputStream(bs)).scale(1).toFile(out);
		} catch (Exception e) {
			log.error("",e);
		}
		
		log.info("done out="+out);
	}
	
	@Before
	public void before() {
		String log4jFileStr = "log4j.properties";
		PropertyConfigurator.configure(log4jFileStr);
	}
}
