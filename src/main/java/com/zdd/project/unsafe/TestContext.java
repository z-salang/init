package com.zdd.project.unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/10/25 ??8:47
 */
public class TestContext {

    private List<TypeInfo> infoList;

    public TestContext() {
        infoList = new ArrayList<>();
    }

    public void add(TypeInfo info) {
        infoList.add(info);
    }

    public void print() {
        infoList.stream().forEach(e -> System.out.println("context: " + e));
    }
}


