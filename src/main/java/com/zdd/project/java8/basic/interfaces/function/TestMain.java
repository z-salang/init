package com.zdd.project.java8.basic.interfaces.function;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/25 ??10:41
 */
public class TestMain {

    public static void main(String[] args) {
        int x = 1;
        int y1 = OperCls.oper(x, OperCls::addOne);
        int y2 = OperCls.oper(x, z -> OperCls.addOne(z));
        int y3 = OperCls.after(x, (z) -> OperCls.addOne(x));
        int y4 = OperCls.after(x, (z) -> OperCls.addOne(z));
        int y5 = OperCls.after(x, (z) -> z * 10);

        System.out.println("y1 = " + y1);
        System.out.println("y2 = " + y2);
        System.out.println("y3 = " + y3);
        System.out.println("y4 = " + y4);
        System.out.println("y5 = " + y5);

    }
}
