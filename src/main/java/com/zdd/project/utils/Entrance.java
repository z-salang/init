package com.zdd.project.utils;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/6/11 ??7:13
 */
public class Entrance {

  public static void main(String[] args) {
    String [] param = new String[]{"ad-test1.sm.cn"};
    try {
      InstallCert.main(param);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
