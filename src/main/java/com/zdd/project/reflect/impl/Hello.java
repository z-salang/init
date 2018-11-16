package com.zdd.project.reflect.impl;

import com.zdd.project.reflect.IHello;

/**
 * Created by zhoudongdong<zdd109067> on 17/4/30.
 */
public class Hello implements IHello {
  @Override
  public void saySomething(String str) {
    System.out.printf("This is what i want to say to you now: %s\n", str);
  }

  @Override
  public String playGames(String gameName) {
    System.out.printf("I am playing %s\n", gameName);
    return "Quadra kill";
  }
}
