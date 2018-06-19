package com.github.bakerzhu.base;

import com.github.bakerzhu.constants.JedisConfigConstants;
import com.github.bakerzhu.inter.AbstractConfig;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.JedisPool;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年06月19日
 * @modifytime:
 */
public class JedisPoolConfig extends AbstractConfig<JedisPool> {

    private final String REDIS_POOL_CONFIG_FILE = JedisConfigConstants.REDIS_CONFIG_FILE;

    private final String REDIS_HOST = "redis.host";
    private final String REDIS_PORT = "redis.port";
    private final String REDIS_PASS = "redis.pass";
    private final String REDIS_DATABASE = "redis.database";
    private final String REDIS_TIMEOUT = "redis.timeout";

    private final String REDIS_POOL_MAXIDLE = "redis.pool.maxIdle";
    private final String REDIS_POOL_MAXACTIVE = "redis.pool.maxActive";
    private final String REDIS_POOL_MAXWAIT = "redis.pool.maxWait";
    private final String REDIS_POOL_TESTONBORROW = "redis.pool.testOnBorrow";

    private JedisPool jedisPool = null;

    public JedisPoolConfig() {
        reloadConfig();
    }

    public String getRedisHost() {
        return getProperty(REDIS_HOST,JedisConfigConstants.REDIS_HOST);
    }

    public int getRedisPort() {
        return getPropertyToInt(REDIS_PORT,JedisConfigConstants.REDIS_PORT);
    }

    public String getRedisPass() {
        return getProperty(REDIS_PASS);
    }

    public int getDataBase() {
        return getPropertyToInt(REDIS_DATABASE,JedisConfigConstants.REDIS_DATABASE);
    }

    public int getTimeout() {
        return getPropertyToInt(REDIS_TIMEOUT,JedisConfigConstants.REDIS_TIMEOUT);
    }

    public int getMaxIdle() {
        return getPropertyToInt(REDIS_POOL_MAXIDLE,JedisConfigConstants.REDIS_POOL_MAXIDLE);
    }

    public int getMaxActive() {
        return getPropertyToInt(REDIS_POOL_MAXACTIVE,JedisConfigConstants.REDIS_POOL_MAXACTIVE);
    }

    public int getMaxWait() {
        return getPropertyToInt(REDIS_POOL_MAXWAIT,JedisConfigConstants.REDIS_POOL_MAXWAIT);
    }

    public String getTestOnBorrow() {
        return getProperty(REDIS_POOL_TESTONBORROW,JedisConfigConstants.REDIS_POOL_TESTONBORROW);
    }


    @Override
    public String getConfigFile() {
        return REDIS_POOL_CONFIG_FILE;
    }

}
