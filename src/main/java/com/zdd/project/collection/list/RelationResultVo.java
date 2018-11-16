package com.zdd.project.collection.list;

import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/6 下午10:20
 */
public class RelationResultVo {
  private int id;
  List<RelationResultVo> childs;


  public RelationResultVo (int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<RelationResultVo> getChilds() {
    return childs;
  }

  public void setChilds(List<RelationResultVo> childs) {
    this.childs = childs;
  }

  @Override public String toString() {
    return "id=" + id;
  }
}
