package com.fanhanfei.springstudy.compile;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhangjunshuai
 * @date 2019/6/24
 * @description
 **/
public class LoaderClassByDir {
    private String classPath;
    private String className;

    public LoaderClassByDir(String classPath) {
        this.classPath = classPath;
    }

    public Class loadClass(String className)
    {
        Class cls = null;
        try {
            URL url = new File(classPath).toURI().toURL();
            URLClassLoader loader = new URLClassLoader(new URL[]{url});
            cls = loader.loadClass(className);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoaderClassByDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(LoaderClassByDir.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cls;
    }

    public void execSayHello(String type) throws Exception {
        Class c = this.loadClass("HelloCompile");
        Method method = c.getMethod("sayHello", String.class);
        method.invoke(c.newInstance(), type);
    }
}
