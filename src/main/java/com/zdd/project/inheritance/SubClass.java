package com.zdd.project.inheritance;

import java.util.Date;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/10/10 下午10:15
 */
public class SubClass extends Super {
  private final Date date;

  public SubClass() {
    this.date = new Date();
  }

  @Override
  public void overrideMe() {
    System.out.println(date);
  }

  public static void main(String[] args) {
    SubClass subClass = new SubClass();
    subClass.overrideMe();
  }
}
