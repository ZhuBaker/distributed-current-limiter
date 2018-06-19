package com.github.bakerzhu.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年06月15日
 * @modifytime:
 */
public final class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader == null) {
            classLoader = FileUtils.class.getClassLoader();
        }
        return classLoader;
    }

    /**
     * 读取静态配置文件的属性(此配置文件仅 load 一次，适用于程序类不在修改的配置文件) ,如果返回null标识读取不成功！
     *
     * @param fileName
     *              文件名(classes目录下)
     * @return
     */
    public static Properties loadStaticProperties(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        logger.debug("loadStaticProperties()-- start,[" + fileName + "]");
        Properties properties = null;
        try {
            ClassLoader classLoader = getClassLoader();
            InputStream is = classLoader.getResourceAsStream(fileName);
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");

            Properties temp = new Properties();
            temp.load(isr);
            properties = new Properties();
            properties.putAll(temp);
            temp.clear();
            temp = null;
            is.close();
            is = null;
            isr.close();
            isr = null;
        } catch (Exception e) {
            logger.error("loadStaticProperties()[" + fileName + "]:" + e);
        }
        return properties;
    }

}
