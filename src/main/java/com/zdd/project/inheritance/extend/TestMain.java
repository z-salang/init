package com.zdd.project.inheritance.extend;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午5:23
 */
public class TestMain {

  public static void main(String[] args) {
    CommonClass b = new BChildClass();

    if (b instanceof BChildClass) {
      System.out.println("b is instance of BClass");
    } else {
      System.out.println("b is not instance of BClass, error ......");
    }

    AChildClass aSub = new AChildClass();
    aSub.setName("super class");
    aSub.setaStr("This is AChild");

    CommonClass aFather = aSub;
    if (aFather instanceof AChildClass) {
      System.out.println("a is instance of AClass");
      AChildClass aChildClass = (AChildClass) aFather;

      System.out.println("Output aStr = " + aChildClass.getaStr());
    }
  }
}
