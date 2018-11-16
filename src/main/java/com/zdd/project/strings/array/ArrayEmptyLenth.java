package com.zdd.project.strings.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/12 下午5:31
 */
public class ArrayEmptyLenth {

  public static void main(String[] args) {

    List<Object> list = new ArrayList();

    Object[] objects = list.toArray();
    System.out.println(objects.length);
  }
}
