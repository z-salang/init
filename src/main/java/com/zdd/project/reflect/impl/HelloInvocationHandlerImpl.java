package com.zdd.project.reflect.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhoudongdong<zdd109067> on 17/4/30.
 */
public class HelloInvocationHandlerImpl implements InvocationHandler {
  private Object target;

  public HelloInvocationHandlerImpl(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Before proxy ...");
    Object retValue = method.invoke(target, args);
    System.out.println("After proxy ...");
    System.out.println("Print retValue : " + retValue);
    return retValue;
  }
}
