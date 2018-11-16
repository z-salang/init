package com.zdd.project.inheritance.extend;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午5:23
 */
public class TestToString {

  public static void main(String[] args) {
    AChildClass aSub = new AChildClass();
    aSub.setName("super class");
    aSub.setaStr("This is AChild");

    System.out.println("aSub = " + aSub);


    CommonClass aFather = aSub;
    System.out.println("father = " + aFather.toString());
  }
}
