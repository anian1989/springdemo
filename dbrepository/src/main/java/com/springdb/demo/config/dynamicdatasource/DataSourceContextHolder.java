package com.springdb.demo.config.dynamicdatasource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjunshuai
 * @date 2019/10/19
 * @description
 **/
@Slf4j
public class DataSourceContextHolder {
    public static final String DEFAULT_DS = "primaryDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
