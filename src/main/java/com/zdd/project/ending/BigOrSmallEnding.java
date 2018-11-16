package com.zdd.project.ending;

import java.nio.ByteOrder;
import sun.misc.Unsafe;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/26 下午8:37
 */
public class BigOrSmallEnding {


  public static void  func(Unsafe unsafe) {
    long longValue = unsafe.allocateMemory(8);
    unsafe.putLong(longValue, 0x0102030405060708L);
    byte memValue = unsafe.getByte(longValue);

    if (memValue == 0x01) {
      System.out.println(ByteOrder.BIG_ENDIAN.toString());
    } else if (memValue == 0x08) {
      System.out.println(ByteOrder.LITTLE_ENDIAN.toString());
    } else {
      System.out.println("null");
    }

    unsafe.freeMemory(longValue);
  }

}
