package com.fanhanfei.springstudy.springAnnotations.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * spring在容器中注入bean的时候，
 * scope默认的是单例模式，
 * 也就是说在整个应用中只能创建一个实例。
 * 当scope为PROTOTYPE类型的时候，
 * 在每次注入的时候会自动创建一个新的bean实例。
 * 但是当一个单例模式的bean去引用PROTOTYPE类型的bean的时候，
 * PROTOTYPE类型的bean也会变成单例。@Lookup注解可以用来解决这个问题
 * <public|protected> [abstract] <return-type> theMethodName(no-arguments);
 * public|protected要求方法必须是可以被子类重写和调用的
 * abstract可选，如果是抽象方法，CGLIB的动态代理类就会实现这个方法，如果不是抽象方法，就会覆盖这个方法
 * return-type是非单例的类型
 * no-arguments不允许有参数
 *
 * @author zhangjunshuai
 * @date 2020/6/1
 * @description
 **/
@Component
public class LookUpDemo {

    @Resource
    private  ClassB classB;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.registerBean(LookUpDemo.class);
        applicationContext.refresh();

        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> {
                LookUpDemo bean = applicationContext.getBean(LookUpDemo.class);
                bean.classB.method();
            }).start();
        }

    }


    @Component
    public abstract class ClassB{
        @Lookup
        public abstract ClassA getClassA();
        public void method(){
            ClassA classA = getClassA();
            System.out.println("The classA hashcode is " + classA.hashCode() + ", The classB hashCode is "+hashCode());
        }
    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class ClassA{

    }
}
