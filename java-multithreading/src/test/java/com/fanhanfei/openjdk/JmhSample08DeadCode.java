package com.fanhanfei.openjdk;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjunshuai
 * @date 2020/7/8
 * @description
 **/
@Deprecated
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JmhSample08DeadCode {
    private double x = Math.PI;

    @Benchmark
    public void baseline() {
        // do nothing, this is a baseline
    }

    @Benchmark
    public void measureWrong() {
        // This is wrong: result is not used and the entire computation is optimized away.
        Math.log(x);
    }

    @Benchmark
    public double measureRight() {
        // This is correct: the result is being used.
        return Math.log(x);
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample08DeadCode.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
