package com.zdd.project.unsafe;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/10/26 ??10:29
 */
public class PrivateTestCls {

    private String name;

    private PrivateTestCls() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
