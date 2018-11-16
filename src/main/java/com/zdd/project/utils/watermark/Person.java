package com.zdd.project.utils.watermark;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/7/1 下午3:25
 */
public class Person {

  private int age;
  private String name;

  public Person() {
    System.out.println("Person()");
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}