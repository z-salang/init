package com.zdd.project.exceptions.continuous_throw;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/3/10 ??4:49
 */
public class MyHandler {

    public void handle() {
        String str = "param: lalalaBaba";
        try {

            function(str);
        } catch (Exception e) {
            System.out.println("failed to handler " + str );
            throw e;
        }

    }

    private void function(String str) {
        throw new RuntimeException("error when call MyHandler.function ..");
    }

}
