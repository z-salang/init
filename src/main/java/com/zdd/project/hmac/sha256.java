package com.zdd.project.hmac;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/3 ??9:19
 */
public class sha256 {

    private static final String MAC_NAME = "HmacSHA256";
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws Exception {
        String key = "HhzsTsl!@#";
        String mid = "ucwebm88419013922406";
        String merchentKey = "CueYFU1aRj5KU5Qt";

        byte[] bytes = hMacSHA1Encrypt(mid, key);

        System.out.println(byte2hex(bytes));
    }

    /**
     * ?? HMAC-SHA1 ??????encryptText????
     *
     * @param encryptText ???????
     * @param encryptKey  ??
     */
    public static byte[] hMacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes(ENCODING);

        //???????????????,???????????????
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        //?????? Mac ?? ? Mac ??
        Mac mac = Mac.getInstance(MAC_NAME);
        //???????? Mac ??
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        //?? Mac ??
        mac.doFinal(text);


        return null;
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }
}
