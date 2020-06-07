package com.fanhanfei.springstudy.springAnnotations.beanwithqualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2020/6/7
 * @description
 **/
@Component
public class FactoryMethodComponent {
    private static int i;

    @Bean
    @Qualifier("public")
    public TestBean publicInstance() {
        return new TestBean("pulicInstance");
    }

    /**
     * 注意Value的表达式
     *
     * @param spouse
     * @param country
     * @return
     */
    @Bean
    protected TestBean protectedInstance(@Qualifier("public") TestBean spouse,

                                         @Value("#{privateInstance.age}") String country) {
        TestBean protectedInstance = new TestBean("protectedInstance", 1);
        protectedInstance.setSpouse(spouse);
        protectedInstance.setCountry(country);
        return protectedInstance;

    }

    @Bean
    private TestBean privateInstance() {
        return new TestBean("privateInstance", i = +2);
    }

}
