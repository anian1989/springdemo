package com.fanhanfei.pattern.jike.create.factory.simple;

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
