package com.zdd.project.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/10/23 上午11:32
 */
public class BatchInsert {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 1; i <= 103; ++i) {
      list.add(i);
    }

    System.out.println("Size of list = " + list.size());

    int from = 0;
    while (from < list.size()) {
      int end = Math.min(list.size(), from + 30);
      List<Integer> sublist =  list.subList(from, end);
      System.out.printf("Size of sublist = %d, sublist = %s\n", sublist.size(), sublist);
      from = end;
    }
  }
}
