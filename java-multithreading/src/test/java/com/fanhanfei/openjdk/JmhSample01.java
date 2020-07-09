package com.fanhanfei.openjdk;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author zhangjunshuai
 * @date 2020/7/7
 * @description
 **/
public class JmhSample01 {


    @Benchmark
    public void wellHelloThere() {
        // do some thing
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample01.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
