package com.zdd.project.Comparable;

import java.util.TreeSet;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/21 ??1:35
 */
public class TestTreeSet {

    public static void main(String[] args) {
        String fp1 = "mysql-bin.123:456:789";
        String fp2 = "mysql-bin.123:457:789";
        String fp3 = "mysql-bin.123:457:790";
        String fp4 = "mysql-bin.124:456:789";

        HiriverEventId e1 = new HiriverEventId();
        e1.decode(fp1);

        HiriverEventId e2 = new HiriverEventId();
        e2.decode(fp2);

        HiriverEventId e3 = new HiriverEventId();
        e3.decode(fp3);

        HiriverEventId e4 = new HiriverEventId();
        e4.decode(fp4);

        TreeSet<HiriverEventId> treeSet = new TreeSet<>();
        treeSet.add(e2);
        treeSet.add(e1);
        treeSet.add(e4);
        treeSet.add(e3);

        System.out.println(treeSet.last().getBinlogPosition() + ":" + treeSet.last().getBatchOffset());
        System.out.println(treeSet.first().getBinlogPosition() + ":" + treeSet.first().getBatchOffset());


    }
}
