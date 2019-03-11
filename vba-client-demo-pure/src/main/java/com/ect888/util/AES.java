package com.ect888.util;


import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Base64;


public class AES
{
    private String key;
    
    public AES() {
        this.key = "B49A86FA425D439dB510A234A3E25A3E";
    }
    
    public AES(final String key) {
        this.key = key;
    }
    
    public static byte[] encrypt(final byte[] byteContent, final byte[] password) throws Exception {
        final KeyGenerator kgen = KeyGenerator.getInstance("AES");
        final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password);
        kgen.init(128, secureRandom);
        final SecretKey secretKey = kgen.generateKey();
        final byte[] enCodeFormat = secretKey.getEncoded();
        final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        final Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, key);
        final byte[] result = cipher.doFinal(byteContent);
        return result;
    }
    
    public static byte[] decrypt(final byte[] content, final byte[] password) throws Exception {
        final KeyGenerator kgen = KeyGenerator.getInstance("AES");
        final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password);
        kgen.init(128, secureRandom);
        final SecretKey secretKey = kgen.generateKey();
        final byte[] enCodeFormat = secretKey.getEncoded();
        final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        final Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, key);
        final byte[] result = cipher.doFinal(content);
        return result;
    }
    
    public final String decrypt(final String data) {
        try {
            return new String(decrypt(this.hex2byte(data), this.key.getBytes()));
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final String decrypt(final String data, final String charsetName) {
        try {
            return new String(decrypt(this.hex2byte(data), this.key.getBytes()), charsetName);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final String encrypt(final String data) {
        try {
            return this.byte2hex(encrypt(data.getBytes(), this.key.getBytes()));
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public final String encrypt(final String data, final String charsetName) {
        try {
            return this.byte2hex(encrypt(data.getBytes(charsetName), this.key.getBytes()));
        }
        catch (Exception e) {
            return null;
        }
    }
    
    private String byte2hex(final byte[] b) {
        return Base64.toBase64String(b);
    }
    
    private byte[] hex2byte(final String hex) throws IOException {
        return Base64.decode(hex);
    }
    
    public void setKey(final String key) {
        this.key = key;
    }
    
    public static void main(final String[] args) {
    }
}
