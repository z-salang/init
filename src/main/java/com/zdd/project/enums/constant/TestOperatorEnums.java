package com.zdd.project.enums.constant;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/1.
 */
public class TestOperatorEnums {

  public static void main(String[] args) {
    System.out.println(OperatorEnums.ADD.calculate(1, 2));
    System.out.println(OperatorEnums.MUL.calculate(5, 6));
    System.out.println(OperatorEnums.DIV.operator);
  }
}
