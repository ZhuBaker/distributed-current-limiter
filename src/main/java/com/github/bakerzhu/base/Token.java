package com.github.bakerzhu.base;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description: 执行结果枚举
 * @time: 2018年06月16日
 * @modifytime:
 */
public enum  Token {

    /**
     * 表示获取limits ,通过
     */
    PASSED,
    /**
     *  表示没有配置基础元数据
     */
    NO_CONFIG,
    /**
     * 表示获取limits失败 拒绝
     */
    REFUSE,
    /**
     * 链接数据源失败
     */
    ACCESS_REDIS_FAIL;


    public boolean isPassed() {
        return this.equals(PASSED);
    }

    public boolean isNoConfig() {
        return this.equals(NO_CONFIG);
    }

    public boolean isAccessRedisFail() {
        return this.equals(ACCESS_REDIS_FAIL);
    }

    public boolean isRefusing() {
        return this.equals(REFUSE);
    }

}
