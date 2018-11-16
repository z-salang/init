package com.zdd.project.java8.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/6 ??3:25
 */
public class TestForRach {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
               numbers.add(i);
            }
        }

        System.out.println(numbers);

        List<Integer> sublist = new ArrayList<>();
        numbers.forEach(number -> {
            if (number > 20) {
                sublist.add(number);
            }
        });

        System.out.println(sublist);
    }
}
