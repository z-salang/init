package com.zdd.project.Comparable;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a >
 * @version create on 2017/12/18 ??5:48
 */
public class ClassCompare implements Comparable<String> {
    private String value;

    public int compare(ClassCompare cls) {
        return this.compareTo(cls.getValue());
    }

    @Override
    public int compareTo(String str) {
        Long[] another = parseLongArr(str);
        Long[] self = parseLongArr(this.value);

        if (self[0].longValue() > another[0].longValue()) {
            return 1;
        } else if (self[0].longValue() == another[0].longValue()) {
            if (self[1].longValue() > another[1].longValue()) {
                return 1;
            } else if (self[1].longValue() == another[1].longValue()) {
                return 0;
            } else return -1;
        } else {
            return -1;
        }
    }

    private Long[] parseLongArr(String str) {
        String[] arr = str.split("-", 2);
        long file = Long.parseLong(arr[0]);
        long pos = Long.parseLong(arr[1]);

        return new Long[]{file, pos};
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static void main(String[] args) {
        String cp1 = "131-223";
        String cp2 = "111-223";

        ClassCompare cls1 = new ClassCompare();
        cls1.setValue(cp1);

        ClassCompare cls2 = new ClassCompare();
        cls2.setValue(cp2);

        System.out.println(cls1.compare(cls2));
    }
}
