package com.fanhanfei.pattern.jike.factory.method;

import com.fanhanfei.pattern.jike.factory.simple.IRuleConfigParser;
import com.fanhanfei.pattern.jike.factory.simple.RuleConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2020/3/18
 * @description
 **/

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new Exception("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}

