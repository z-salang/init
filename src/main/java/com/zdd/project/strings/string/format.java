package com.zdd.project.strings.string;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/18 上午11:33
 */
public class format {

  public static void main(String[] args) {
    String start = "20170501";
    String end = "20170502";
    String format = String.format("TRANSACTION-INFORMATION-%s-%s.csv", start, end);
    System.out.println(format);
  }
}
