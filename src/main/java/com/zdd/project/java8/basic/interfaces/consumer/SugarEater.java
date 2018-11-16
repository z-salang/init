package com.zdd.project.java8.basic.interfaces.consumer;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/11 ??3:23
 */
public class SugarEater {

    public String sugarName;

    public SugarEater(String sugarName) {
        this.sugarName = sugarName;
    }

    public void likeEat(MyConsumer<String> consumer) {
        consumer.consume(sugarName);
    }
}
