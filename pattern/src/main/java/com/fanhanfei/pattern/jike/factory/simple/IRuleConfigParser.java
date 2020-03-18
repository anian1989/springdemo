package com.fanhanfei.pattern.jike.factory.simple;

/**
 * @author zhangjunshuai
 * @date 2020/3/18
 * @description
 **/
public interface IRuleConfigParser {

    /**
     * 分析文件
     * @param configText
     * @return
     */
    RuleConfig parse(String configText);
}
