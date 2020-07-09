package com.fanhanfei.openjdk;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;
/**
 * @author zhangjunshuai
 * @date 2020/7/8
 * @description
 **/
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
public class JmhSample20Annotations {
    double x1 = Math.PI;

    /*
     * In addition to all the command line options usable at run time,
     * we have the annotations which can provide the reasonable defaults
     * for the some of the benchmarks. This is very useful when you are
     * dealing with lots of benchmarks, and some of them require
     * special treatment.
     *
     * Annotation can also be placed on class, to have the effect over
     * all the benchmark methods in the same class. The rule is, the
     * annotation in the closest scope takes the precedence: i.e.
     * the method-based annotation overrides class-based annotation,
     * etc.
     */

    @Benchmark
    @Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
    public double measure() {
        return Math.log(x1);
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample20Annotations.class.getSimpleName())
                .warmupIterations(3)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(4)
                .measurementTime(TimeValue.seconds(2))
                .build();

        new Runner(opt).run();
    }
}
