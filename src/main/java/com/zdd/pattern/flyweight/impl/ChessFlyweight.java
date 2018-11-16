package com.zdd.pattern.flyweight.impl;

import com.zdd.pattern.flyweight.Flyweight;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/18 ??11:10
 */
public class ChessFlyweight implements Flyweight {

    private String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void showPosition(Coordinate coordinate) {
        System.out.println("x:y -> [" + coordinate.getX() + "," + coordinate.getY() + "]");
    }
}
