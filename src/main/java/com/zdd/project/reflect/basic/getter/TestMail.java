package com.zdd.project.reflect.basic.getter;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/17 下午5:46
 */
public class TestMail {

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class<?> child = Class.forName(Child.class.getName());

    Object o = child.newInstance();
    Field[] childFields = o.getClass().getDeclaredFields();
    for (Field f : childFields) {
      System.out.println("Child : " + f.getName());
    }

    Class<?> father = Class.forName(Father.class.getName());

    Object o1 = father.newInstance();
    Field[] fatherFields = o1.getClass().getDeclaredFields();
    for (Field f : fatherFields) {
      System.out.println("Father : " + f.getName());
    }


  }
}
