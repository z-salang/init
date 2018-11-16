package com.zdd.project.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/7/30 上午12:43
 */
public class TestListRetainAll {

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
    part.add("ff");
    part.add("gg");

    boolean b = all.retainAll(part);

    System.out.println(all);
    System.out.println(part);
    System.out.println(b);
  }
}
