package com.zdd.project.java8.basic.interfaces.consumer;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/11 ??3:15
 */
public class TestMain {

    public static void main(String[] args) {

        SugarEater sugarEater = new SugarEater("White sugar");

        sugarEater.likeEat((x) -> {
            System.out.println("I like eat " + x);
        });

    }
}
