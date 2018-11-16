package com.zdd.pattern.flyweight;

import com.zdd.pattern.flyweight.impl.ChessFlyWeightFactory;
import com.zdd.pattern.flyweight.impl.ChessFlyweight;
import com.zdd.pattern.flyweight.impl.Coordinate;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/18 ??11:27
 */
public class TestMain {


    public static void main(String[] args) {
        ChessFlyweight flyweight1 = ChessFlyWeightFactory.get("black");
        ChessFlyweight flyweight2 = ChessFlyWeightFactory.get("black");

        System.out.println(flyweight1);
        System.out.println(flyweight2);

        flyweight1.showPosition(new Coordinate(1,2));
        flyweight2.showPosition(new Coordinate(3,4));

    }
}
