package com.zdd.project.builder;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/1.
 */
public class ManyParams {
  private int a1;
  private int a2;
  private int a3;
  private int a4;
  private int a5;
  private int a6;

  public static class ManyParamsBuilder {
    private int a1;
    private int a2;
    private int a3;
    private int a4;
    private int a5;
    private int a6;

    public ManyParamsBuilder setA1(int a1) {
      this.a1 = a1;
      return this;
    }

    public ManyParamsBuilder setA2(int a2) {
      this.a2 = a2;
      return this;
    }

    public ManyParamsBuilder setA3(int a3) {
      this.a3 = a3;
      return this;
    }

    public ManyParamsBuilder setA4(int a4) {
      this.a4 = a4;
      return this;
    }

    public ManyParamsBuilder setA5(int a5) {
      this.a5 = a5;
      return this;
    }

    public ManyParamsBuilder setA6(int a6) {
      this.a6 = a6;
      return this;
    }

    public ManyParams build() {
      return new ManyParams(this);
    }
  }

  private ManyParams(ManyParamsBuilder builder) {
    this.a1 = builder.a1;
    this.a2 = builder.a2;
    this.a3 = builder.a3;
    this.a4 = builder.a4;
    this.a5 = builder.a5;
    this.a6 = builder.a6;
  }

  public int getA1() {
    return a1;
  }

  public int getA2() {
    return a2;
  }

  public int getA3() {
    return a3;
  }

  public int getA4() {
    return a4;
  }

  public int getA5() {
    return a5;
  }

  public int getA6() {
    return a6;
  }
}
