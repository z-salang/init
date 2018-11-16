package com.zdd.project.inheritance.extend;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午5:22
 */
public class BChildClass extends CommonClass {
  private String bStr;

  public String getbStr() {
    return bStr;
  }

  public void setbStr(String bStr) {
    this.bStr = bStr;
  }

  //@Override
  //public String toString() {
  //  return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  //}
}
