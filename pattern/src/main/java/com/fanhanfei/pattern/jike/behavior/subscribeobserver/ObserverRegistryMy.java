package com.fanhanfei.pattern.jike.behavior.subscribeobserver;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zhangjunshuai
 * @date 2020/4/7
 * @description
 **/
public class ObserverRegistryMy {
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();
    public void register(Object object){

        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(object);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> key = entry.getKey();
            Collection<ObserverAction> value = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> orDefault = registry.getOrDefault(key, new CopyOnWriteArraySet<>());
            orDefault.addAll(value);
        }

    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer){
        Map<Class<?>, Collection<ObserverAction>> resultMap = new HashMap<>();
        Class<?> aClass = observer.getClass();
        for (Method method : getAnnotationMethods(aClass)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> parameterType = parameterTypes[0];
            if (!resultMap.containsKey(parameterType)){
                resultMap.putIfAbsent(parameterType, new ArrayList<>());
            }
            resultMap.get(parameterType).add(new ObserverAction(aClass,method));
        }
        return resultMap;


    }


    private List<Method> getAnnotationMethods(Class<?> clazz){
        ArrayList<Method> methodsList = Lists.newArrayList();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length ==1,"method %s 订阅方法有 %s 参数，Subscribe要求 1个 cans ",method,parameterTypes.length);
                methodsList.add(method);
            }
        }
        return methodsList;
    }
    @Subscribe
    private void test(SubscribeMessage message){

    }

    public static void main(String[] args) {


        ObserverRegistryMy observerRegistryMy = new ObserverRegistryMy();
        observerRegistryMy.register(observerRegistryMy);

    }


}
