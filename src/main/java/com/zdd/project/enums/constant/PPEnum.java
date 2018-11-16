package com.zdd.project.enums.constant;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/1 ??7:52
 */
public enum PPEnum {

    PP1("pp1", 1),
    PP2("pp2", 2);

    private String name;
    private int value;

    PPEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
