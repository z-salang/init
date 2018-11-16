package com.zdd.project.enums.constant;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/1.
 */
public enum OperatorEnums {

  ADD("+") {
    @Override
    public int calculate(int a, int b) {
      return a + b;
    }
  },
  SUB("-") {
    @Override
    public int calculate(int a, int b) {
      return a - b;
    }
  },
  MUL("*") {
    @Override
    public int calculate(int a, int b) {
      return a * b;
    }
  },
  DIV("/") {
    @Override
    public int calculate(int a, int b) {
      if (b == 0) {
        throw new IllegalArgumentException("divisor must not be 0");
      }

      return a / b;
    }
  };

  public final String operator;

  OperatorEnums(String operator) {
    this.operator = operator;
  }

  public abstract int calculate(int a, int b);

}
