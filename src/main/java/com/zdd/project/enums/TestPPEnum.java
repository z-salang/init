package com.zdd.project.enums;

import com.zdd.project.enums.constant.PPEnum;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/1 ??7:55
 */
public class TestPPEnum {

    public static void main(String[] args) {
        PPEnum pp = PPEnum.PP1;

        System.out.println(pp.getName());
        pp.setName("123123");
        System.out.println(pp.getName());

    }
}
