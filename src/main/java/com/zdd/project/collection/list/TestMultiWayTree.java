package com.zdd.project.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/6 下午11:37
 */
public class TestMultiWayTree {

  static StringBuilder stringBuilder = new StringBuilder();
  static List<String> paths = new ArrayList<>();
  static List<String> tempPath = new ArrayList<>();

  public static void getPath(RelationResultVo root) {
    if (root != null) {

      tempPath.add(String.valueOf(root.getId()));

      List<RelationResultVo> childs = root.getChilds();

      if (childs == null || childs.isEmpty()) {
        for (String element : tempPath) {
          stringBuilder.append(element).append('-');
        }

        String path = stringBuilder.toString();
        paths.add(path.substring(0, path.length() - 1));

        stringBuilder = new StringBuilder();
        tempPath.remove(tempPath.size() - 1);

        return ;
      } else {
        for (RelationResultVo child : childs) {
          getPath(child);
        }
        tempPath.remove(tempPath.size() - 1);
      }

    }
  }

  public static void main(String[] args) {
    RelationResultVo n1 = new RelationResultVo(1);

    List<RelationResultVo> level2 = new ArrayList<>();
    RelationResultVo n2 = new RelationResultVo(2);
    RelationResultVo n3 = new RelationResultVo(3);
    RelationResultVo n4 = new RelationResultVo(4);
    level2.add(n2);
    level2.add(n3);
    level2.add(n4);

    n1.setChilds(level2);
    // ==========================================
    List<RelationResultVo> level31 = new ArrayList<>();
    RelationResultVo n5 = new RelationResultVo(5);
    RelationResultVo n6 = new RelationResultVo(6);
    RelationResultVo n7 = new RelationResultVo(7);
    level31.add(n5);
    level31.add(n6);
    level31.add(n7);

    n2.setChilds(level31);
    // ==========================================
    List<RelationResultVo> level32 = new ArrayList<>();
    RelationResultVo n8 = new RelationResultVo(8);
    RelationResultVo n9 = new RelationResultVo(9);
    RelationResultVo n10 = new RelationResultVo(10);
    level32.add(n8);
    level32.add(n9);
    level32.add(n10);

    n3.setChilds(level32);
    // ==========================================

    getPath(n1);

    System.out.println(paths);

  }
}
