package com.zdd.project.collection.list;

import java.util.Collection;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/8/28 下午11:45
 */
public class TestListTClass {

  public static void main(String[] args) {
    //List<Integer> list = new ArrayList<>();
    //list.add(1);
    //list.add(2);
    //list.add(3);
    //printCollecton(list);
  }

  public static <T extends TestListTClass>  void printCollecton(Collection<T> collection) {

    return;
  }

  public static <T> T autoConvertType(T obj)
  {
    return obj;
  }
}
