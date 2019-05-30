package com.fanhanfei.springdemo.JMH;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjunshuai
 * @date 2019/5/29
 * @description
 **/
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Slf4j
public class BenchmarkMy {
    @Param({"4","5","6"})
    private int length;

    public static void main(String[] args) throws RunnerException {
        Options build =
                new OptionsBuilder()
                        .include(BenchmarkMy.class.getSimpleName())
                        .forks(1).warmupIterations(1)
                        .measurementBatchSize(3)
                        .build();
        new Runner(build).run();
    }

    @Benchmark
    public void measureName() {
        try {
            int i = length * 1000;
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Setup
    public void setUp() {
        log.info("测试开始");
    }

    @TearDown
    public void setDown() {
        log.info("测试结束");
    }

}
