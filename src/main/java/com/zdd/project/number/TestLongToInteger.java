package com.zdd.project.number;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/6 下午6:01
 */
public class TestLongToInteger {

  public static void main(String[] args) {
    Integer integer = new Integer(123111);
    Long ll = integer.longValue();

    System.out.println(ll.intValue());
  }
}
