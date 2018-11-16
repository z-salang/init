package com.zdd.project.inheritance.extend;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/22 下午5:21
 */
public class AChildClass extends CommonClass {
  private String aStr;

  public String getaStr() {
    return aStr;
  }

  public void setaStr(String aStr) {
    this.aStr = aStr;
  }

  //@Override
  //public String toString() {
  //  return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  //}
}
