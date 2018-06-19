package com.github.bakerzhu.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年06月19日
 * @modifytime:
 */
public class JedisConfigConstants {

    public static final String REDIS_CONFIG_FILE = "redis-config.properties";

    public static final String REDIS_HOST = "127.0.0.1";

    public static final int REDIS_PORT = 6379;

    public static final int REDIS_DATABASE = 0;

    public static final int REDIS_TIMEOUT = 2000;



    public static final int REDIS_POOL_MAXIDLE = 300;

    public static final int REDIS_POOL_MAXACTIVE = 600;

    public static final int REDIS_POOL_MAXWAIT = 1000;

    public static final String REDIS_POOL_TESTONBORROW = "true";



}
