package com.zdd.project.hmac;


import com.google.common.base.Strings;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/4 ??10:28
 */
public class HMAC {
    /**
     * ??????
     * MAC??????????
     * <pre>
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     * </pre>
     */
    private final static String KEY_MAC = "HmacMD5";

    /**
     * ????
     */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * ????
     */
    public HMAC() {

    }

    /**
     * BASE64 ??
     * @param key ?????????
     * @return ???
     * @throws Exception
     */
    public static String encryptBase64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * BASE64 ??
     * @param key ????????
     * @return ????
     * @throws Exception
     */
    public static byte[] decryptBase64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * HMAC??
     * @param data ?????????
     * @param key ??
     * @return ????
     */
    public static byte[] encryptHMAC(byte[] data, String key) {
        SecretKey secretKey;
        byte[] bytes = null;
        try {
            secretKey = new SecretKeySpec(decryptBase64(key), KEY_MAC);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * HMAC??
     * @param data ????????
     * @param key ??
     * @return ???
     */
    public static String encryptHMAC(String data, String key) {
        if (Strings.isNullOrEmpty(data)) {
            return null;
        }
        byte[] bytes = encryptHMAC(data.getBytes(), key);
        return byteArrayToHexString(bytes);
    }


    /**
     * ??????????????????
     * @param b ????
     * @return ???
     */
    private static String byteToHexString(byte b) {
        int ret = b;
        if (ret < 0) {
            ret += 256;
        }
        int m = ret / 16;
        int n = ret % 16;
        return hexDigits[m] + hexDigits[n];
    }

    /**
     * ??????????????
     * @param bytes ????
     * @return ???????
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();
    }

    /**
     * ????
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String key = "HhzsTsl!@#";
        String mid = "ucwebm88419013922406";
        String merchentKey = "CueYFU1aRj5KU5Qt";

//        byte[] bytes = encryptHMAC(mid.getBytes(), key);
//        String encryptHMAC = new String(bytes);

        String encryptHMAC = encryptHMAC(mid, key);
//
        System.out.println("encryptHMAC = " + encryptHMAC);

        System.out.println(new String(decryptBase64(encryptHMAC)));
    }

}
