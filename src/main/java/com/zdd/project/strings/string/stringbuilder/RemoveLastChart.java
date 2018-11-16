package com.zdd.project.strings.string.stringbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/12 下午5:10
 */
public class RemoveLastChart {

  public static void main(String[] args) {
    List<Long> userids = new ArrayList<Long>();
    userids.add(1111L);
    userids.add(2222L);
    userids.add(3333L);
    userids.add(4444L);

    StringBuilder sbUserids = new StringBuilder();
    for (Long id : userids) {
      sbUserids.append(id.longValue()).append(",");
    }

    sbUserids.deleteCharAt(sbUserids.length() - 1);

    System.out.println(sbUserids.toString());
  }
}
