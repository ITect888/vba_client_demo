package com.ect888.util;

import java.util.zip.*;
import java.io.*;

public class Base64
{
    public static final int NO_OPTIONS = 0;
    public static final int ENCODE = 1;
    public static final int DECODE = 0;
    public static final int GZIP = 2;
    public static final int DONT_BREAK_LINES = 8;
    public static final int URL_SAFE = 16;
    public static final int ORDERED = 32;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte EQUALS_SIGN = 61;
    private static final byte NEW_LINE = 10;
    private static final String PREFERRED_ENCODING = "UTF-8";
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte[] _STANDARD_ALPHABET;
    private static final byte[] _STANDARD_DECODABET;
    private static final byte[] _URL_SAFE_ALPHABET;
    private static final byte[] _URL_SAFE_DECODABET;
    private static final byte[] _ORDERED_ALPHABET;
    private static final byte[] _ORDERED_DECODABET;
    
    private static final byte[] getAlphabet(final int options) {
        if ((options & 0x10) == 0x10) {
            return Base64._URL_SAFE_ALPHABET;
        }
        if ((options & 0x20) == 0x20) {
            return Base64._ORDERED_ALPHABET;
        }
        return Base64._STANDARD_ALPHABET;
    }
    
    private static final byte[] getDecodabet(final int options) {
        if ((options & 0x10) == 0x10) {
            return Base64._URL_SAFE_DECODABET;
        }
        if ((options & 0x20) == 0x20) {
            return Base64._ORDERED_DECODABET;
        }
        return Base64._STANDARD_DECODABET;
    }
    
    public static final void main(final String[] args) {
        if (args.length < 3) {
            usage("Not enough arguments.");
        }
        else {
            final String flag = args[0];
            final String infile = args[1];
            final String outfile = args[2];
            if (flag.equals("-e")) {
                encodeFileToFile(infile, outfile);
            }
            else if (flag.equals("-d")) {
                decodeFileToFile(infile, outfile);
            }
            else {
                usage("Unknown flag: " + flag);
            }
        }
    }
    
    private static final void usage(final String msg) {
        System.err.println(msg);
        System.err.println("Usage: java Base64 -e|-d inputfile outputfile");
    }
    
    private static byte[] encode3to4(final byte[] b4, final byte[] threeBytes, final int numSigBytes, final int options) {
        encode3to4(threeBytes, 0, numSigBytes, b4, 0, options);
        return b4;
    }
    
    private static byte[] encode3to4(final byte[] source, final int srcOffset, final int numSigBytes, final byte[] destination, final int destOffset, final int options) {
        final byte[] ALPHABET = getAlphabet(options);
        final int inBuff = ((numSigBytes > 0) ? (source[srcOffset] << 24 >>> 8) : 0) | ((numSigBytes > 1) ? (source[srcOffset + 1] << 24 >>> 16) : 0) | ((numSigBytes > 2) ? (source[srcOffset + 2] << 24 >>> 24) : 0);
        switch (numSigBytes) {
            case 3: {
                destination[destOffset] = ALPHABET[inBuff >>> 18];
                destination[destOffset + 1] = ALPHABET[inBuff >>> 12 & 0x3F];
                destination[destOffset + 2] = ALPHABET[inBuff >>> 6 & 0x3F];
                destination[destOffset + 3] = ALPHABET[inBuff & 0x3F];
                return destination;
            }
            case 2: {
                destination[destOffset] = ALPHABET[inBuff >>> 18];
                destination[destOffset + 1] = ALPHABET[inBuff >>> 12 & 0x3F];
                destination[destOffset + 2] = ALPHABET[inBuff >>> 6 & 0x3F];
                destination[destOffset + 3] = 61;
                return destination;
            }
            case 1: {
                destination[destOffset] = ALPHABET[inBuff >>> 18];
                destination[destOffset + 1] = ALPHABET[inBuff >>> 12 & 0x3F];
                destination[destOffset + 3] = (destination[destOffset + 2] = 61);
                return destination;
            }
            default: {
                return destination;
            }
        }
    }
    
    public static String encodeObject(final Serializable serializableObject) {
        return encodeObject(serializableObject, 0);
    }
    
    public static String encodeObject(final Serializable serializableObject, final int options) {
        ByteArrayOutputStream baos = null;
        java.io.OutputStream b64os = null;
        ObjectOutputStream oos = null;
        GZIPOutputStream gzos = null;
        final int gzip = options & 0x2;
        final int dontBreakLines = options & 0x8;
        try {
            baos = new ByteArrayOutputStream();
            b64os = new OutputStream(baos, 0x1 | options);
            if (gzip == 2) {
                gzos = new GZIPOutputStream(b64os);
                oos = new ObjectOutputStream(gzos);
            }
            else {
                oos = new ObjectOutputStream(b64os);
            }
            oos.writeObject(serializableObject);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (oos != null) {
                try {
                    oos.close();
                }
                catch (Exception ex) {}
            }
            if (gzos != null) {
                try {
                    gzos.close();
                }
                catch (Exception ex2) {}
            }
            if (b64os != null) {
                try {
                    b64os.close();
                }
                catch (Exception ex3) {}
            }
            if (baos != null) {
                try {
                    baos.close();
                }
                catch (Exception ex4) {}
            }
        }
        try {
            return new String(baos.toByteArray(), "UTF-8");
        }
        catch (UnsupportedEncodingException uue) {
            return new String(baos.toByteArray());
        }
    }
    
    public static String encodeBytes(final byte[] source) {
        return encodeBytes(source, 0, source.length, 0);
    }
    
    public static String encodeBytes(final byte[] source, final int options) {
        return encodeBytes(source, 0, source.length, options);
    }
    
    public static String encodeBytes(final byte[] source, final int off, final int len) {
        return encodeBytes(source, off, len, 0);
    }
    
    public static String encodeBytes(final byte[] source, final int off, final int len, final int options) {
        final int dontBreakLines = options & 0x8;
        final int gzip = options & 0x2;
        if (gzip == 2) {
            ByteArrayOutputStream baos = null;
            GZIPOutputStream gzos = null;
            OutputStream b64os = null;
            try {
                baos = new ByteArrayOutputStream();
                b64os = new OutputStream(baos, 0x1 | options);
                gzos = new GZIPOutputStream(b64os);
                gzos.write(source, off, len);
                gzos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            finally {
                if (gzos != null) {
                    try {
                        gzos.close();
                    }
                    catch (Exception ex) {}
                }
                if (b64os != null) {
                    try {
                        b64os.close();
                    }
                    catch (Exception ex2) {}
                }
                if (baos != null) {
                    try {
                        baos.close();
                    }
                    catch (Exception ex3) {}
                }
            }
            try {
                return new String(baos.toByteArray(), "UTF-8");
            }
            catch (UnsupportedEncodingException uue) {
                return new String(baos.toByteArray());
            }
        }
        final boolean breakLines = dontBreakLines == 0;
        final int len2 = len * 4 / 3;
        final byte[] outBuff = new byte[len2 + ((len % 3 > 0) ? 4 : 0) + (breakLines ? (len2 / 76) : 0)];
        int d = 0;
        int e2 = 0;
        final int len3 = len - 2;
        int lineLength = 0;
        while (d < len3) {
            encode3to4(source, d + off, 3, outBuff, e2, options);
            lineLength += 4;
            if (breakLines && lineLength == 76) {
                outBuff[e2 + 4] = 10;
                ++e2;
                lineLength = 0;
            }
            d += 3;
            e2 += 4;
        }
        if (d < len) {
            encode3to4(source, d + off, len - d, outBuff, e2, options);
            e2 += 4;
        }
        try {
            return new String(outBuff, 0, e2, "UTF-8");
        }
        catch (UnsupportedEncodingException uue2) {
            return new String(outBuff, 0, e2);
        }
    }
    
    private static int decode4to3(final byte[] source, final int srcOffset, final byte[] destination, final int destOffset, final int options) {
        final byte[] DECODABET = getDecodabet(options);
        if (source[srcOffset + 2] == 61) {
            final int outBuff = (DECODABET[source[srcOffset]] & 0xFF) << 18 | (DECODABET[source[srcOffset + 1]] & 0xFF) << 12;
            destination[destOffset] = (byte)(outBuff >>> 16);
            return 1;
        }
        if (source[srcOffset + 3] == 61) {
            final int outBuff = (DECODABET[source[srcOffset]] & 0xFF) << 18 | (DECODABET[source[srcOffset + 1]] & 0xFF) << 12 | (DECODABET[source[srcOffset + 2]] & 0xFF) << 6;
            destination[destOffset] = (byte)(outBuff >>> 16);
            destination[destOffset + 1] = (byte)(outBuff >>> 8);
            return 2;
        }
        try {
            final int outBuff = (DECODABET[source[srcOffset]] & 0xFF) << 18 | (DECODABET[source[srcOffset + 1]] & 0xFF) << 12 | (DECODABET[source[srcOffset + 2]] & 0xFF) << 6 | (DECODABET[source[srcOffset + 3]] & 0xFF);
            destination[destOffset] = (byte)(outBuff >> 16);
            destination[destOffset + 1] = (byte)(outBuff >> 8);
            destination[destOffset + 2] = (byte)outBuff;
            return 3;
        }
        catch (Exception e) {
            System.out.println("" + source[srcOffset] + ": " + DECODABET[source[srcOffset]]);
            System.out.println("" + source[srcOffset + 1] + ": " + DECODABET[source[srcOffset + 1]]);
            System.out.println("" + source[srcOffset + 2] + ": " + DECODABET[source[srcOffset + 2]]);
            System.out.println("" + source[srcOffset + 3] + ": " + DECODABET[source[srcOffset + 3]]);
            return -1;
        }
    }
    
    public static byte[] decode(final byte[] source, final int off, final int len, final int options) {
        final byte[] DECODABET = getDecodabet(options);
        final int len2 = len * 3 / 4;
        final byte[] outBuff = new byte[len2];
        int outBuffPosn = 0;
        final byte[] b4 = new byte[4];
        int b4Posn = 0;
        int i = 0;
        byte sbiCrop = 0;
        byte sbiDecode = 0;
        for (i = off; i < off + len; ++i) {
            sbiCrop = (byte)(source[i] & 0x7F);
            sbiDecode = DECODABET[sbiCrop];
            if (sbiDecode < -5) {
                System.err.println("Bad Base64 input character at " + i + ": " + source[i] + "(decimal)");
                return null;
            }
            if (sbiDecode >= -1) {
                b4[b4Posn++] = sbiCrop;
                if (b4Posn > 3) {
                    outBuffPosn += decode4to3(b4, 0, outBuff, outBuffPosn, options);
                    b4Posn = 0;
                    if (sbiCrop == 61) {
                        break;
                    }
                }
            }
        }
        final byte[] out = new byte[outBuffPosn];
        System.arraycopy(outBuff, 0, out, 0, outBuffPosn);
        return out;
    }
    
    public static byte[] decode(final String s) {
        return decode(s, 0);
    }
    
    public static byte[] decode(final String s, final int options) {
        byte[] bytes;
        try {
            bytes = s.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException uee) {
            bytes = s.getBytes();
        }
        bytes = decode(bytes, 0, bytes.length, options);
        if (bytes != null && bytes.length >= 4) {
            final int head = (bytes[0] & 0xFF) | (bytes[1] << 8 & 0xFF00);
            if (35615 == head) {
                ByteArrayInputStream bais = null;
                GZIPInputStream gzis = null;
                ByteArrayOutputStream baos = null;
                final byte[] buffer = new byte[2048];
                int length = 0;
                try {
                    baos = new ByteArrayOutputStream();
                    bais = new ByteArrayInputStream(bytes);
                    gzis = new GZIPInputStream(bais);
                    while ((length = gzis.read(buffer)) >= 0) {
                        baos.write(buffer, 0, length);
                    }
                    bytes = baos.toByteArray();
                }
                catch (IOException e) {}
                finally {
                    if (baos != null) {
                        try {
                            baos.close();
                        }
                        catch (Exception ex) {}
                    }
                    if (gzis != null) {
                        try {
                            gzis.close();
                        }
                        catch (Exception ex2) {}
                    }
                    if (bais != null) {
                        try {
                            bais.close();
                        }
                        catch (Exception ex3) {}
                    }
                }
            }
        }
        return bytes;
    }
    
    public static Object decodeToObject(final String encodedObject) {
        final byte[] objBytes = decode(encodedObject);
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            bais = new ByteArrayInputStream(objBytes);
            ois = new ObjectInputStream(bais);
            obj = ois.readObject();
        }
        catch (IOException e) {
            e.printStackTrace();
            obj = null;
        }
        catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            obj = null;
        }
        finally {
            try {
                bais.close();
            }
            catch (Exception ex) {}
            try {
                ois.close();
            }
            catch (Exception ex2) {}
        }
        return obj;
    }
    
    public static boolean encodeToFile(final byte[] dataToEncode, final String filename) {
        boolean success = false;
        OutputStream bos = null;
        try {
            bos = new OutputStream(new FileOutputStream(filename), 1);
            bos.write(dataToEncode);
            success = true;
        }
        catch (IOException e) {
            success = false;
        }
        finally {
            try {
                bos.close();
            }
            catch (Exception ex) {}
        }
        return success;
    }
    
    public static boolean decodeToFile(final String dataToDecode, final String filename) {
        boolean success = false;
        OutputStream bos = null;
        try {
            bos = new OutputStream(new FileOutputStream(filename), 0);
            bos.write(dataToDecode.getBytes("UTF-8"));
            success = true;
        }
        catch (IOException e) {
            success = false;
        }
        finally {
            try {
                bos.close();
            }
            catch (Exception ex) {}
        }
        return success;
    }
    
    public static byte[] decodeFromFile(final String filename) {
        byte[] decodedData = null;
        InputStream bis = null;
        try {
            final File file = new File(filename);
            byte[] buffer = null;
            int length = 0;
            int numBytes = 0;
            if (file.length() > 2147483647L) {
                System.err.println("File is too big for this convenience method (" + file.length() + " bytes).");
                return null;
            }
            for (buffer = new byte[(int)file.length()], bis = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0); (numBytes = bis.read(buffer, length, 4096)) >= 0; length += numBytes) {}
            decodedData = new byte[length];
            System.arraycopy(buffer, 0, decodedData, 0, length);
        }
        catch (IOException e) {
            System.err.println("Error decoding from file " + filename);
        }
        finally {
            if (bis != null) {
                try {
                    bis.close();
                }
                catch (Exception ex) {}
            }
        }
        return decodedData;
    }
    
    public static String encodeFromFile(final String filename) {
        String encodedData = null;
        InputStream bis = null;
        try {
            final File file = new File(filename);
            byte[] buffer;
            int length;
            int numBytes;
            for (buffer = new byte[Math.max((int)(file.length() * 1.4), 40)], length = 0, numBytes = 0, bis = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1); (numBytes = bis.read(buffer, length, 4096)) >= 0; length += numBytes) {}
            encodedData = new String(buffer, 0, length, "UTF-8");
        }
        catch (IOException e) {
            System.err.println("Error encoding from file " + filename);
        }
        finally {
            try {
                bis.close();
            }
            catch (Exception ex) {}
        }
        return encodedData;
    }
    
    public static boolean encodeFileToFile(final String infile, final String outfile) {
        boolean success = false;
        java.io.InputStream in = null;
        java.io.OutputStream out = null;
        try {
            in = new InputStream(new BufferedInputStream(new FileInputStream(infile)), 1);
            out = new BufferedOutputStream(new FileOutputStream(outfile));
            final byte[] buffer = new byte[65536];
            int read = -1;
            while ((read = in.read(buffer)) >= 0) {
                out.write(buffer, 0, read);
            }
            success = true;
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                in.close();
            }
            catch (Exception ex) {}
            try {
                out.close();
            }
            catch (Exception ex2) {}
        }
        return success;
    }
    
    public static boolean decodeFileToFile(final String infile, final String outfile) {
        boolean success = false;
        java.io.InputStream in = null;
        java.io.OutputStream out = null;
        try {
            in = new InputStream(new BufferedInputStream(new FileInputStream(infile)), 0);
            out = new BufferedOutputStream(new FileOutputStream(outfile));
            final byte[] buffer = new byte[65536];
            int read = -1;
            while ((read = in.read(buffer)) >= 0) {
                out.write(buffer, 0, read);
            }
            success = true;
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                in.close();
            }
            catch (Exception ex) {}
            try {
                out.close();
            }
            catch (Exception ex2) {}
        }
        return success;
    }
    
    static {
        _STANDARD_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        _STANDARD_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
        _URL_SAFE_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        _URL_SAFE_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
        _ORDERED_ALPHABET = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
        _ORDERED_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9 };
    }
    
    public static class InputStream extends FilterInputStream
    {
        private boolean encode;
        private int position;
        private byte[] buffer;
        private int bufferLength;
        private int numSigBytes;
        private int lineLength;
        private boolean breakLines;
        private int options;
        private byte[] alphabet;
        private byte[] decodabet;
        
        public InputStream(final java.io.InputStream in) {
            this(in, 0);
        }
        
        public InputStream(final java.io.InputStream in, final int options) {
            super(in);
            this.breakLines = ((options & 0x8) != 0x8);
            this.encode = ((options & 0x1) == 0x1);
            this.bufferLength = (this.encode ? 4 : 3);
            this.buffer = new byte[this.bufferLength];
            this.position = -1;
            this.lineLength = 0;
            this.options = options;
            this.alphabet = getAlphabet(options);
            this.decodabet = getDecodabet(options);
        }
        
        public int read() throws IOException {
            if (this.position < 0) {
                if (this.encode) {
                    final byte[] b3 = new byte[3];
                    int numBinaryBytes = 0;
                    for (int i = 0; i < 3; ++i) {
                        try {
                            final int b4 = this.in.read();
                            if (b4 >= 0) {
                                b3[i] = (byte)b4;
                                ++numBinaryBytes;
                            }
                        }
                        catch (IOException e) {
                            if (i == 0) {
                                throw e;
                            }
                        }
                    }
                    if (numBinaryBytes <= 0) {
                        return -1;
                    }
                    encode3to4(b3, 0, numBinaryBytes, this.buffer, 0, this.options);
                    this.position = 0;
                    this.numSigBytes = 4;
                }
                else {
                    final byte[] b5 = new byte[4];
                    int j;
                    int b6;
                    for (j = 0, j = 0; j < 4; ++j) {
                        b6 = 0;
                        do {
                            b6 = this.in.read();
                        } while (b6 >= 0 && this.decodabet[b6 & 0x7F] <= -5);
                        if (b6 < 0) {
                            break;
                        }
                        b5[j] = (byte)b6;
                    }
                    if (j == 4) {
                        this.numSigBytes = decode4to3(b5, 0, this.buffer, 0, this.options);
                        this.position = 0;
                    }
                    else {
                        if (j == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                }
            }
            if (this.position < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (this.position >= this.numSigBytes) {
                return -1;
            }
            if (this.encode && this.breakLines && this.lineLength >= 76) {
                this.lineLength = 0;
                return 10;
            }
            ++this.lineLength;
            final int b7 = this.buffer[this.position++];
            if (this.position >= this.bufferLength) {
                this.position = -1;
            }
            return b7 & 0xFF;
        }
        
        public int read(final byte[] dest, final int off, final int len) throws IOException {
            int i = 0;
            while (i < len) {
                final int b = this.read();
                if (b >= 0) {
                    dest[off + i] = (byte)b;
                    ++i;
                }
                else {
                    if (i == 0) {
                        return -1;
                    }
                    break;
                }
            }
            return i;
        }
    }
    
    public static class OutputStream extends FilterOutputStream
    {
        private boolean encode;
        private int position;
        private byte[] buffer;
        private int bufferLength;
        private int lineLength;
        private boolean breakLines;
        private byte[] b4;
        private boolean suspendEncoding;
        private int options;
        private byte[] alphabet;
        private byte[] decodabet;
        
        public OutputStream(final java.io.OutputStream out) {
            this(out, 1);
        }
        
        public OutputStream(final java.io.OutputStream out, final int options) {
            super(out);
            this.breakLines = ((options & 0x8) != 0x8);
            this.encode = ((options & 0x1) == 0x1);
            this.bufferLength = (this.encode ? 3 : 4);
            this.buffer = new byte[this.bufferLength];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = options;
            this.alphabet = getAlphabet(options);
            this.decodabet = getDecodabet(options);
        }
        
        public void write(final int theByte) throws IOException {
            if (this.suspendEncoding) {
                super.out.write(theByte);
                return;
            }
            if (this.encode) {
                this.buffer[this.position++] = (byte)theByte;
                if (this.position >= this.bufferLength) {
                    this.out.write(encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
                    this.lineLength += 4;
                    if (this.breakLines && this.lineLength >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            }
            else if (this.decodabet[theByte & 0x7F] > -5) {
                this.buffer[this.position++] = (byte)theByte;
                if (this.position >= this.bufferLength) {
                    final int len = decode4to3(this.buffer, 0, this.b4, 0, this.options);
                    this.out.write(this.b4, 0, len);
                    this.position = 0;
                }
            }
            else if (this.decodabet[theByte & 0x7F] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }
        
        public void write(final byte[] theBytes, final int off, final int len) throws IOException {
            if (this.suspendEncoding) {
                super.out.write(theBytes, off, len);
                return;
            }
            for (int i = 0; i < len; ++i) {
                this.write(theBytes[off + i]);
            }
        }
        
        public void flushBase64() throws IOException {
            if (this.position > 0) {
                if (!this.encode) {
                    throw new IOException("Base64 input not properly padded.");
                }
                this.out.write(encode3to4(this.b4, this.buffer, this.position, this.options));
                this.position = 0;
            }
        }
        
        public void close() throws IOException {
            this.flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }
        
        public void suspendEncoding() throws IOException {
            this.flushBase64();
            this.suspendEncoding = true;
        }
        
        public void resumeEncoding() {
            this.suspendEncoding = false;
        }
    }
}
