package com.zdd.file;

import java.io.IOException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/9/19 ??7:22
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
        ReadFileEngine engine = new ReadFileEngine();
        engine.start("/Users/zdd/data_amind/hc_charged_log20181225.sql");
    }

}
