package com.github.bakerzhu;

import com.github.bakerzhu.base.JedisPoolConfig;
import com.github.bakerzhu.base.LimiterInitBean;
import com.github.bakerzhu.base.Token;
import com.github.bakerzhu.constants.RateLimiterConstants;
import com.github.bakerzhu.limiter.LimiterOperation;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年06月19日
 * @modifytime:
 */
public class LimiterOperationTest {

    @Test
    public void test1() {
        LimiterInitBean bean = new LimiterInitBean();
        bean.setKey("rate:limiter");
        bean.setMaxPermits("10");
        bean.setRate("2");
        bean.setApps("zhangsan,lisi,wangwu,zhaoliu,qianqi");
        bean.setOperate(RateLimiterConstants.RATE_LIMITER_INIT);

        JedisPoolConfig config = new JedisPoolConfig();
        LimiterOperation operation = new LimiterOperation(config);
        boolean b = operation.limiterInit(bean);
        System.out.println(b);
    }

    @Test
    public void test2() throws Exception{
        JedisPoolConfig config = new JedisPoolConfig();
        LimiterOperation operation = new LimiterOperation(config);
        for(int i = 0 ; i< 20; i ++) {
            Token token = operation.acquireToken("rate:limiter", "wangwu", 2);
            Thread.sleep(500L);
        }
        Thread.sleep(1000L);
    }
}
