package com.zdd.project.unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/10/26 ??10:29
 */
public class TestReflection {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TestContext context = new TestContext();

        TypeInfo info1 = new TypeInfo("aaa");
        TypeInfo info2 = new TypeInfo("bbb");
        TypeInfo info3 = new TypeInfo("ccc");

        context.add(info1);
        context.add(info2);
        context.add(info3);

        Class<TestContext> contextClass = TestContext.class;
        for (Field f : contextClass.getDeclaredFields()) {
            if (f.getName().equals("infoList")) {
                f.setAccessible(true);
                try {
                    Object o = f.get(context);
                    ArrayList<TypeInfo> typeList = (ArrayList) o;
                    System.out.println("list ======== " + typeList);

                    Iterator<TypeInfo> iterator = typeList.iterator();
                    while (iterator.hasNext()) {
                        TypeInfo next = iterator.next();
                        if (next.getId().equals("aaa") || next.getId().equals("bbb")) {
                            iterator.remove();
                        }
                    }

                    f.set(context, typeList);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        context.print();
    }

}
