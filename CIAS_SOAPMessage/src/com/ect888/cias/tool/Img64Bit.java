package com.ect888.cias.tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

public class Img64Bit {

	public static boolean GenerateImage(String imgStr, String imgFilePath)
			throws IOException {
		if (null == imgStr || imgStr.length() <= 0) {
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();

		byte[] code_bt = decoder.decodeBuffer(imgStr);

		ByteArrayInputStream imageStream = new ByteArrayInputStream(code_bt);
		BufferedImage image = ImageIO.read(imageStream);

		System.out.println(image.getHeight(null));
		System.out.println(image.getWidth(null));
		System.out.println(imgFilePath);
		ImageIO.write(image, "jpeg", new File(imgFilePath));

		return true;
	}

}
