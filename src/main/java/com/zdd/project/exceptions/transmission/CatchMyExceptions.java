package com.zdd.project.exceptions.transmission;

import com.zdd.project.exceptions.constants.BusinessException;
import com.zdd.project.exceptions.constants.MyDefException;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/6.
 */
public class CatchMyExceptions {

  public void m1() {
    //try {
      System.out.println("Before to exec m2()");
      m2();
      System.out.println("After to exec m2()");
    //} catch (MyDefException e) {
    //  System.err.println("Errors occurrence when exec m2()");
    //  //throw new BusinessException("M1 to catch MyDefException");
    //}
  }

  public void m2() throws BusinessException {
    //try {
      System.out.println("Before to exec m3()");
      //m3();
      System.out.println("After to exec m3()");

      throw new RuntimeException("m2 throws a RuntimeException ...");
    //} catch (MyDefException e) {
    //  //throw new BusinessException("M2 to catch MyDefException");
    //  System.err.println("Errors occurrence when exec m3()");
    //}
  }

  public void m3() {
    System.out.println("Before to exec throw exception");
    throw new MyDefException("m3 throws a MyDefException ...");
  }
}
