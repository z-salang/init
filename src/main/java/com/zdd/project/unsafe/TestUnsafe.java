package com.zdd.project.unsafe;

import com.google.common.collect.Lists;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/10/25 ??8:52
 */
public class TestUnsafe {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //  =====================   Unsafe  ==============================
//        test1();  // ??
        test2(); // ??

        System.out.println();
        System.out.println("======================");
        System.out.println();

        test3();
        System.out.println();
        System.out.println("======================");
        System.out.println();

        test4();
    }


    private static void test3() {
        TestContext context = new TestContext();

        TypeInfo info1 = new TypeInfo("aaa");
        TypeInfo info2 = new TypeInfo("bbb");
        TypeInfo info3 = new TypeInfo("ccc");

        context.add(info1);
        context.add(info2);
        context.add(info3);

        try {
            long infoListOffset = unsafe.objectFieldOffset(TestContext.class.getDeclaredField("infoList"));
            System.out.println("offset : " + infoListOffset);

            ArrayList<TypeInfo> list = (ArrayList) unsafe.getObject(context, infoListOffset);
            System.out.println("listType : " + list);

            ArrayList<TypeInfo> unsafeList = Lists.newArrayList(new TypeInfo("fuck"));
            unsafe.putObject(context, infoListOffset, unsafeList);
            context.print();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void test4() {
        int[] arr = {1, 2, 3};
        //??????????????
        long arrayOffset = unsafe.arrayBaseOffset(arr.getClass());
        //????????????
        long scale = unsafe.arrayIndexScale(arr.getClass());
        unsafe.putInt(arr, arrayOffset + scale * 2, 1000);
        System.out.println(Arrays.toString(arr));
    }

    // ???Unsafe??????private???????
    private static void test2() {
        try {
            PrivateTestCls cls = (PrivateTestCls) unsafe.allocateInstance(PrivateTestCls.class);
            cls.setName("A private cls");

            System.out.println(cls.getName());

        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    // ???????????private???????????IllegalAccessException
    private static void test1() {
        try {

            PrivateTestCls cls = PrivateTestCls.class.newInstance();
            cls.setName("123123123");

            System.out.println(cls.getName());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
