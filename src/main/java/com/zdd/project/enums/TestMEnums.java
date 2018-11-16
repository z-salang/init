package com.zdd.project.enums;

import com.zdd.project.enums.constant.MEnum;

/**
 * Created by zhoudongdong<zdd109067> on 17/4/30.
 */
public class TestMEnums {

    public static void main(String[] args) {
        MEnum e = MEnum.of(2);

        System.out.println(e.code + "-" + e.msg);

        MEnum e1 = MEnum.of(5);
        System.out.println(e1.code + "-" + e1.msg);

    }
}
