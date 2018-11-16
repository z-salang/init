package com.zdd.project.hmac;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/4 ??10:59
 */
public class Base64 {

    public static void main(String[] args) {
        String key = "HhzsTsl!@#";
        String mid = "ucwebm88419013922406";
        String merchentKey = "CueYFU1aRj5KU5Qt";

        String midEncode = encryptBASE64(mid.getBytes());
        System.out.println("midEncode = " + midEncode);

        String keyEncode = encryptBASE64(key.getBytes());

        String combine = midEncode + keyEncode;
        String combineEncode = encryptBASE64(combine.getBytes());
        System.out.println("combineEncode = " + combineEncode);

        System.out.println("====================");

        try {

            byte[] combineBytes = decryptBASE64(combineEncode);
            String combineStr = new String(combineBytes);
            System.out.println("combineStr = " + combineStr);


            String[] split = combineStr.split(key);
            String midEncodeStr = split[0];
            byte[] midBytes = decryptBASE64(midEncodeStr);
            System.out.println(new String(midBytes));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * BASE64??
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64??
     */
    public static String encryptBASE64(byte[] key) {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
