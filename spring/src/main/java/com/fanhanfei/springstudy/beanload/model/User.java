package com.fanhanfei.springstudy.beanload.model;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author zhangjunshuai
 * @date 2020/5/27
 * @description
 **/
@Data
public class User implements BeanNameAware {
    private Long id;

    private String name;

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

    private Resource configFileLocation;

    private Company company;

    private Properties context;

    private String contextAsText;

    /**
     * 当前 Bean 的名称
     */
    private transient String beanName;

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("小马哥");
        return user;
    }

    @PostConstruct
    public void init() {
        System.out.println("User Bean [" + beanName + "] 初始化...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("User Bean [" + beanName + "] 销毁中...");
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", configFileLocation=" + configFileLocation +
                ", company=" + company +
                ", context=" + context +
                ", contextAsText='" + contextAsText + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
