package com.fanhanfei.springstudy.provideinterface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author zhangjunshuai
 * @date 2020/6/1
 * @description
 **/
public class MethodReplaceDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("method-replace/method-replaces.xml");

        ReplacementTarget replacementTarget = (ReplacementTarget) applicationContext
                .getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) applicationContext
                .getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);

        applicationContext.close();
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 100; x++) {
            String foo = target.formatMessage("foo");
        }

        stopWatch.stop();

        System.out.println("1000000 invocations took: "
                + stopWatch.getTotalTimeMillis() + " ms");
    }
}
