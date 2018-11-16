package com.zdd.project.exceptions.constants;

/**
 * Created by zhoudongdong<zdd109067> on 17/5/6.
 */
public class BusinessException extends RuntimeException {

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }
}
