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

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JmhSample11Loops {


    int x = 1;
    int y = 2;


    @Benchmark
    public int measureRight() {
        return (x + y);
    }

    /*
     * The following tests emulate the naive looping.
     * This is the Caliper-style benchmark.
     */
    private int reps(int reps) {
        int s = 0;
        for (int i = 0; i < reps; i++) {
            s += (x + y);
        }
        return s;
    }

    /*
     * We would like to measure this with different repetitions count.
     * Special annotation is used to get the individual operation cost.
     */

   /* @Benchmark
    @OperationsPerInvocation(1)
    public int measureWrong_1() {
        return reps(1);
    }

    @Benchmark
    @OperationsPerInvocation(10)
    public int measureWrong_10() {
        return reps(10);
    }

    @Benchmark
    @OperationsPerInvocation(100)
    public int measureWrong_100() {
        return reps(100);
    }

    @Benchmark
    @OperationsPerInvocation(1_000)
    public int measureWrong_1000() {
        return reps(1_000);
    }

    @Benchmark
    @OperationsPerInvocation(10_000)
    public int measureWrong_10000() {
        return reps(10_000);
    }*/

    @Benchmark
    @OperationsPerInvocation(100)
    public int measureWrong_100000() {
        return reps(100_000);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample11Loops.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
