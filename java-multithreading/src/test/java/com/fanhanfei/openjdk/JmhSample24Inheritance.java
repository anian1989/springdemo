package com.fanhanfei.openjdk;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;

import java.util.concurrent.TimeUnit;
/**
 * @author zhangjunshuai
 * @date 2020/7/9
 * @description
 **/
public class JmhSample24Inheritance {
    /*
     * In very special circumstances, you might want to provide the benchmark
     * body in the (abstract) superclass, and specialize it with the concrete
     * pieces in the subclasses.
     *
     * The rule of thumb is: if some class has @Benchmark method, then all the subclasses
     * are also having the "synthetic" @Benchmark method. The caveat is, because we only
     * know the type hierarchy during the compilation, it is only possible during
     * the same compilation session. That is, mixing in the subclass extending your
     * benchmark class *after* the JMH compilation would have no effect.
     *
     * Note how annotations now have two possible places. The closest annotation
     * in the hierarchy wins.
     */

    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @State(Scope.Thread)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public static abstract class AbstractBenchmark {
        int x;

        @Setup
        public void setup() {
            x = 42;
        }

        @Benchmark
        @Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
        @Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
        public double bench() {
            return doWork() * doWork();
        }

        protected abstract double doWork();
    }

    public static class BenchmarkLog extends AbstractBenchmark {
        @Override
        protected double doWork() {
            return Math.log(x);
        }
    }

    public static class BenchmarkSin extends AbstractBenchmark {
        @Override
        protected double doWork() {
            return Math.sin(x);
        }
    }

    public static class BenchmarkCos extends AbstractBenchmark {
        @Override
        protected double doWork() {
            return Math.cos(x);
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample24Inheritance.class.getSimpleName())
                .verbosity(VerboseMode.SILENT)
                .build();

        new Runner(opt).run();
    }
}
