package com.fanhanfei.springstudy.compile;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author zhangjunshuai
 * @date 2019/6/25
 * @description 使用Sun的tools.jar包时的com.sun.tools.javac.Main类完成对代码的编译。
 **/
public class MainCompile {


    private static String filePath = "/Users/zhangjunshuai/workspace/paopao/springdemo/src/test/java/com/fanhanfei/springdemo/compile/HelloCompile.java";
    private static String binDir = "/Users/zhangjunshuai/workspace/paopao/springdemo/src/test/java/";

    public static void main(String[] args) {
        File binOutDir = new File(binDir);
        if (!binOutDir.exists()) {
            binOutDir.mkdirs();
        }

        Main.compile(new String[]{"-encoding", "UTF-8","-d", binDir, filePath});
        try {

            // 加载编译好的类，并调用相应的方法
            new LoaderClassByDir(binDir).execSayHello("sun tools");

        } catch (Exception ex) {
            Logger.getLogger(JavacCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
