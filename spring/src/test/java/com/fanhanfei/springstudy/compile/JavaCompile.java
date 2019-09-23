package com.fanhanfei.springstudy.compile;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
/**
 * @author zhangjunshuai
 * @date 2019/6/25
 * @description 使用javax.tools包
 **/
public class JavaCompile {
    private static String filePath = "/Users/zhangjunshuai/workspace/paopao/springdemo/src/test/java/com/fanhanfei/springdemo/compile/HelloCompile.java";
    private static String binDir = "/Users/zhangjunshuai/workspace/paopao/springdemo/src/test/java/";

    public static void main(String[] args) {
        File binOutDir = new File(binDir);
        if (!binOutDir.exists())
        {
            binOutDir.mkdirs();
        }

        // 将编译参数通过数组传递到编译方法中，该函数的方法和javac的参数完成一致
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, "-encoding", "UTF-8","-d", binDir, filePath);
        try {
            // 加载编译好的类，并调用相应的方法
            new LoaderClassByDir(binDir).execSayHello("javax.tools");
        } catch (Exception ex) {
            Logger.getLogger(JavacCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
