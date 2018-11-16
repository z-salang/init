package com.zdd.project.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/7/30 上午12:40
 */
public class TestListRemoveAll {

  public static void main(String[] args) {
    List<String> all = new ArrayList<>();
    all.add("aa");
    all.add("bb");
    all.add("cc");
    all.add("dd");
    all.add("ee");

    List<String> part = new ArrayList<>();
    part.add("cc");
    part.add("ee");

    all.removeAll(part);

    System.out.println(all);
  }

}
