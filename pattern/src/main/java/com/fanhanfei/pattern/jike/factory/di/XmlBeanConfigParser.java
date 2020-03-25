package com.fanhanfei.pattern.jike.factory.di;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/3/19
 * @description
 **/
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        // TODO:...
         return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List beanDefinitions = new ArrayList<>();
        // TODO:...
         return beanDefinitions;
    }
}

