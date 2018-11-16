package com.zdd.project.unsafe;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/10/25 ??8:50
 */
public class TypeInfo {

    private String id;

    public TypeInfo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "id='" + id + '\'' +
                '}';
    }
}
