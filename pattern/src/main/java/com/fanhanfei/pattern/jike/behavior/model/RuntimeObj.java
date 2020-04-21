package com.fanhanfei.pattern.jike.behavior.model;

import java.util.Collection;
import java.util.IdentityHashMap;

/**
 * @author zhangjunshuai
 * @date 2020/4/17
 * @description
 **/
public class RuntimeObj {
    public void addShutdowmHook(Thread hook) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new RuntimePermission("shutdownHooks"));
        }
        ApplicationShutdownHooks.add(hook);
    }

    public static RuntimeObj getRuntime(){
        return new RuntimeObj();
    }

}

class ApplicationShutdownHooks {
    private static IdentityHashMap<Thread, Thread> hooks;

    static {
        hooks = new IdentityHashMap<>();
    }

    static synchronized void add(Thread hook) {
        if (hooks == null)
            throw new IllegalStateException("Shutdown in progress");
        if (hook.isAlive())
            throw new IllegalArgumentException("Hook already running");
        if (hooks.containsKey(hook))
            throw new IllegalArgumentException("Hook previously registered");
        hooks.put(hook, hook);
    }

    static void runHooks(){
        Collection<Thread> threads;
        synchronized (ApplicationShutdownHooks.class){
            threads = hooks.keySet();
            hooks = null;
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            while (true){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }
}
