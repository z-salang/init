package com.zdd.project.number;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/10/18 下午4:26
 */
public class UnsignedAndSignedTrans {
  public static void main(String[] args) {

    System.out.println(unsignedToSigned("16398017956019010671111"));

  }

  /**
   * 无符号转有符号
   */
  public static long unsignedToSigned(String string) {
    return new BigInteger(string).longValue();
  }

  /**
   * 有符号转无符号
   */
  public static final BigDecimal signedToUnsigned(long value) {
    if (value >= 0) {
      return new BigDecimal(value);
    }
    long lowValue = value & 0x7fffffffffffffffL;
    return BigDecimal.valueOf(lowValue).add(BigDecimal.valueOf(Long.MAX_VALUE)).add(BigDecimal.valueOf(1));
  }
}
