package com.fanhanfei.pattern.jike.factory.method;

import com.fanhanfei.pattern.jike.factory.simple.IRuleConfigParser;
import com.fanhanfei.pattern.jike.factory.simple.JsonRuleConfigParser;

/**
 * @author zhangjunshuai
 * @date 2020/3/18
 * @description
 **/
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
