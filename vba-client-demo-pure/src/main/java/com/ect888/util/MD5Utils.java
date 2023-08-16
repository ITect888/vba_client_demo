package com.ect888.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class MD5Utils {

    private static final Log log = LogFactory.getLog(MD5Utils.class);

    /**
     * 产生MD5, 格式为32字节的16进制编码
     *
     * @param message 原始值
     * @return 32位MD5值
     * @throws Exception
     */
    public static String md5(String message) {
        try {
            // 产生 MD5 Hash(16字节)
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(message.getBytes(Charset.forName("UTF-8")));
            byte messageDigest[] = digest.digest();

            // 16进制编码(32字节)
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString((messageDigest[i] & 0xFF) | 0x100).substring(1, 3));

            return hexString.toString();
        } catch (Exception e) {
            log.error("无法生成MD5字符串", e);
            return message;
        }
    }
}
