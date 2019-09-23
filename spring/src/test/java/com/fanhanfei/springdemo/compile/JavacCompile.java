package com.fanhanfei.springdemo.compile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author zhangjunshuai
 * @date 2019/6/24
 * @description
 **/
public class JavacCompile {

    private static String filePath = "/Users/zhangjunshuai/workspace/paopao/springdemo/src/test/java/com/fanhanfei/springdemo/compile/HelloCompile.java";
    private static String binDir = "/Users/zhangjunshuai/workspace/paopao/springdemo/src/test/java/";

    public static void main(String[] args) {
        File binOutDir = new File(binDir);
        if (!binOutDir.exists()) {
            binOutDir.mkdirs();
        }

        // 设置javac的编译参数，使用-encoding指定编码方式，-d并指定编译生成class文件目录
        ProcessBuilder pb = new ProcessBuilder("javac", "-encoding", "UTF-8", "-d", binDir, filePath);
        try {
            // 开始调用javac命令编译
            final Process proc = pb.start();

            // 处理进程的输出，避免挂死
            new Thread(() -> {
                processStream(proc.getInputStream());
                processStream(proc.getErrorStream());
            }).start();

            // 等待编译完成
            proc.waitFor();

            // 加载编译好的类，并调用相应的方法
            new LoaderClassByDir(binDir).execSayHello("javac");

        } catch (Exception ex) {
            Logger.getLogger(JavacCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processStream(InputStream stderr) {
        String result = new BufferedReader(new InputStreamReader(stderr))
                .lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println("输出："+result);

    }
}
