package com.fanhanfei.pattern.jike.factory.method;

import com.fanhanfei.pattern.jike.factory.simple.IRuleConfigParser;

/**
 * @author zhangjunshuai
 * @date 2020/3/18
 * @description 使用工厂方法是因为创建对象的逻辑十分复杂
 **/
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
