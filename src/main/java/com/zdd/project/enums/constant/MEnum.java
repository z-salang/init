package com.zdd.project.enums.constant;

/**
 * Created by zhoudongdong<zdd109067> on 17/4/30.
 */
public enum MEnum {

  FIRST(1, "first"),
  SECOND(2, "seceond"),
  THIRD(3, "third");

  public final int code;
  public final String msg;

  MEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static MEnum of(int code) {
    for (MEnum e : values()) {
      if (e.code == code) {
        return e;
      }
    }

    return FIRST;
  }
}
