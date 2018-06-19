package com.github.bakerzhu.limiter;

import com.github.bakerzhu.base.JedisPoolConfig;
import com.github.bakerzhu.base.JedisPoolFactory;
import com.github.bakerzhu.base.LimiterInitBean;
import com.github.bakerzhu.base.Token;
import com.github.bakerzhu.constants.RateLimiterConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年06月19日
 * @modifytime:
 */
public class LimiterOperation {

    private static final Logger logger = LoggerFactory.getLogger(LimiterOperation.class);

    private static String PATH  = null;

    private static String LUA_SCRIPT = null;

    private JedisPoolConfig config = null;

    static {
        try {
            PATH = LimiterOperation.class.getResource("/").getPath() + "lua/rate_limiter.lua";
            LUA_SCRIPT = org.apache.commons.io.FileUtils.readFileToString(new File(PATH), Charset.forName("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public LimiterOperation(JedisPoolConfig poolConfig) {
        this.config = poolConfig;
    }

    /**
     * 获取令牌
     * @param key
     * @param context
     * @param permits
     * @return
     */
    public Token acquireToken(String key , String context, int permits) {
        Token token = Token.REFUSE;
        Jedis jedis = null;
        try {
            jedis = JedisPoolFactory.getClient(config);
            long l = System.currentTimeMillis();
            long eval = (long)jedis.eval(LUA_SCRIPT,4,key,Integer.toString(permits),Long.toString(l) ,context, RateLimiterConstants.RATE_LIMITER_ACQUIRE);
            System.out.println(eval);
            if(eval == 1) {
                token = Token.PASSED;
            }else if (eval == 0) {
                token = Token.NO_CONFIG;
            }else if (eval == -1) {
                token = Token.REFUSE;
            }
        }catch (Exception e) {
            e.printStackTrace();
            token = Token.ACCESS_REDIS_FAIL;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
        return token;
    }


    /**
     * 初始化令牌信息
     * @param initBean
     * @return
     */
    public boolean limiterInit(LimiterInitBean initBean) {
        Jedis jedis = null;
        try{
            jedis = JedisPoolFactory.getClient(config);
            long eval = (long)jedis.eval(LUA_SCRIPT, 4,
                    initBean.getKey(),
                    initBean.getMaxPermits(),
                    initBean.getRate(),
                    initBean.getApps(),
                    initBean.getOperate());
            if(eval == 1) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return false;
    }






}
