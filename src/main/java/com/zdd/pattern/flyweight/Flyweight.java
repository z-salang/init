package com.zdd.pattern.flyweight;

import com.zdd.pattern.flyweight.impl.Coordinate;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/18 ??11:08
 */
public interface Flyweight {

    void setColor(String color);

    String getColor();

    void showPosition(Coordinate coordinate);
}
