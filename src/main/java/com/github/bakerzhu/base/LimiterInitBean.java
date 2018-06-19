package com.github.bakerzhu.base;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年06月19日
 * @modifytime:
 */
public class LimiterInitBean {

    private String key ;

    private String maxPermits;

    private String rate;

    private String apps;

    private String operate;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMaxPermits() {
        return maxPermits;
    }

    public void setMaxPermits(String maxPermits) {
        this.maxPermits = maxPermits;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}
