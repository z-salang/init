package com.zdd.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/5/10 ??12:08
 */
public class Test {

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.parse("2018-11-01 00:00:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime dateTime = startTime.minusMinutes(60);

        System.out.println(startTime);
        System.out.println(dateTime);
    }
}
