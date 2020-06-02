package com.fanhanfei.springstudy.scope.customescope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2020/6/1
 * @description
 **/
public class ThreadScope implements Scope {
    public static final String SCOPE_NAME = "thread-local";
    private final NamedThreadLocal threadLocal = new NamedThreadLocal("thread-local-scope"){
        @Override
        public Map<String,Object> initialValue(){
            return new HashMap<>();
        }
    };
    @NonNull
    private Map<String, Object> getContext() {
        return (Map<String, Object>) threadLocal.get();
    }
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object object = context.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            context.putIfAbsent(name, object);
        }
        return  object;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // TODO
    }

    @Override
    public Object resolveContextualObject(String key) {
        Map<String, Object> context = getContext();
        return context.get(key);
    }

    @Override
    public String getConversationId() {
        Thread thread = Thread.currentThread();
        return String.valueOf(thread.getId());
    }
}
