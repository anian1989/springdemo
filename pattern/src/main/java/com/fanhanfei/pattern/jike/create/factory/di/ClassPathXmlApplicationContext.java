package com.fanhanfei.pattern.jike.create.factory.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/3/19
 * @description
 **/
public class ClassPathXmlApplicationContext implements Application {
    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } catch (Exception e){

        } finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) { // TODO: log error
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
