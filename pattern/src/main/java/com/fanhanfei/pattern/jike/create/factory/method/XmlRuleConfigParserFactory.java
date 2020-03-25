package com.fanhanfei.pattern.jike.create.factory.method;

import com.fanhanfei.pattern.jike.create.factory.simple.IRuleConfigParser;
import com.fanhanfei.pattern.jike.create.factory.simple.XmlRuleConfigParser;

/**
 * @author zhangjunshuai
 * @date 2020/3/18
 * @description
 **/
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
