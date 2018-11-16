package com.zdd.project.builder;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/1.
 */
public class TestManyParamsBuilder {

  public static void main(String[] args) {
    ManyParams.ManyParamsBuilder builder = new ManyParams.ManyParamsBuilder();
    builder.setA1(1).setA2(2).setA3(3).setA3(3222);
    ManyParams obj = builder.build();

    System.out.println(obj.getA1());
    System.out.println(obj.getA2());
    System.out.println(obj.getA3());

  }
}
