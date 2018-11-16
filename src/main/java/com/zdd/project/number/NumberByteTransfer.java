package com.zdd.project.number;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/7 ??5:20
 */
public class NumberByteTransfer {
    public static byte[] longToBytes(long values) {
        byte[] buffer = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = 64 - (i + 1) * 8;
            buffer[i] = (byte) ((values >> offset) & 0xff);
        }
        return buffer;
    }

    public static long bytesToLong(byte[] buffer) {
        long  values = 0;
        for (int i = 0; i < 8; i++) {
            values <<= 8; values|= (buffer[i] & 0xff);
        }
        return values;
    }

    public static void main(String[] args) {
        long ll =  -Long.MAX_VALUE;

        byte[] bytes = longToBytes(ll);

        System.out.println(bytes);

        long aLong = bytesToLong(bytes);

        System.out.println(aLong);
    }
}
