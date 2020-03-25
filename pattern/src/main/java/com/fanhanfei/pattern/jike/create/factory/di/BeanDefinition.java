package com.fanhanfei.pattern.jike.create.factory.di;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/3/19
 * @description
 **/
@Data
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public static enum Scope {SINGLETON, PROTOTYPE}

    @Data
    public static class ConstructorArg {
        private boolean ref;
        private Class type;
        private Object arg;
    }
}
