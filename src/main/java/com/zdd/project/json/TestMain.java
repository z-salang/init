package com.zdd.project.json;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2019/1/8 下午5:03
 */
public class TestMain {

    public static void main(String[] args) {
        Account account1 = new Account(1001L, 9999L, "test1");
        Account account2 = new Account(1002L, 9999L, "test2");

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        String json = JsonUtil.toJson(accountList);
        System.out.println(json);

        ArrayList arrayList = JsonUtil.fromJson(json, ArrayList.class);
        System.out.println("size : " + arrayList.size() + ", content = " + arrayList);
    }
}
