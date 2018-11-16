package com.zdd.project.reflect.impl;

import com.zdd.project.reflect.IHello;
import com.zdd.project.reflect.IManyPeople;
import com.zdd.project.reflect.INoHello;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/27 下午3:00
 */
public class ManyPeople implements IManyPeople, INoHello, IHello {
  @Override
  public void myName(String name) {
    System.out.println("My name is " + name);
  }

  @Override
  public void sayWhatTheFuck() {
    System.out.println("Holy shit ..");
  }

  @Override
  public void saySomething(String str) {
    System.out.println(str);
  }

  @Override
  public String playGames(String gameName) {
    System.out.println("Many people playing " + gameName);
    return "Winner";
  }
}
