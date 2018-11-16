package com.zdd.pattern.pipe.chain.pipeline;

import com.zdd.pattern.pipe.chain.pipeline.impl.AppendHandler;
import com.zdd.pattern.pipe.chain.pipeline.impl.DefaultPipeline;
import com.zdd.pattern.pipe.chain.pipeline.impl.FilterHandler;
import com.zdd.pattern.pipe.chain.pipeline.impl.FunnyHandler;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/1/10 ??5:17
 */
public class TestMain {

    public static void main(String[] args) {
        Pipeline<String> pipeline1 = new DefaultPipeline();
        pipeline1.addFirst(new FilterHandler()).addFirst(new AppendHandler());

        pipeline1.start("Sleeping ");

        System.out.println("=============");

        Pipeline<String> pipeline2 = new DefaultPipeline();
        pipeline2.addFirst(new FunnyHandler()).addFirst(new AppendHandler());
        pipeline2.start("Sleeping ");
    }
}
