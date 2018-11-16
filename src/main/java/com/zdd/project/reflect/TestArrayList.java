package com.zdd.project.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/2.
 */
public class TestArrayList {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    List<Integer> list = new ArrayList<Integer>();
    list.add(11);
    list.add(55);

    Method addMethod = list.getClass().getMethod("add", Object.class);
    addMethod.invoke(list, "Java反射机制测试");
    Object o1 = list.get(1);
    Object o2 = list.get(2);

    System.out.println(o1.getClass().getName()); // java.lang.Integer
    System.out.println(o2.getClass().getName()); // java.lang.String
  }
}
