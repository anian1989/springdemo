package com.fanhanfei.pattern.jike.factory.simple;

/**
 * @author zhangjunshuai
 * @date 2020/3/18
 * @description
 **/
public class RuleConfigParserFactory {

    public static  IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        }
        return parser;
    }
}
