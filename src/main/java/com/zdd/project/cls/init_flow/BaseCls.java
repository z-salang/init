package com.zdd.project.cls.init_flow;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/15 ??1:01
 */
public class BaseCls {
//    private String name = "base";
    private static String name = "base";

    public BaseCls() {
        callName();
    }

    public static void callName() {
        System.out.println("Call name = " + name);
    }

//    public void callName() {
//        System.out.println("Call name = " + name);
//    }


    static class SecondSubCls extends BaseCls {
        private static String name = "secondSub";

        public SecondSubCls() {
            callName();
        }

        public static void callName() {
            System.out.println("Call name = " + name);
        }

//        public void callName() {
//            System.out.println("Call name = " + name);
//        }
    }

    public static void main(String[] args) {
        BaseCls cls = new BaseCls.SecondSubCls();
    }
}
