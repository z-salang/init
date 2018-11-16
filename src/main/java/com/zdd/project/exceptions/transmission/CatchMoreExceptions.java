package com.zdd.project.exceptions.transmission;

import com.zdd.project.exceptions.constants.AException;
import com.zdd.project.exceptions.constants.BException;
import com.zdd.project.exceptions.constants.BusinessException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/6/29 上午11:00
 */
public class CatchMoreExceptions {

  static void fun3() {
    try {
      fun1();
      fun2();
    } catch (AException | BException b) {
      b.printStackTrace();
    }
  }

  static void fun1() throws AException {
    throw new BusinessException("");
  }

  static void fun2 () throws BException {

  }
}
