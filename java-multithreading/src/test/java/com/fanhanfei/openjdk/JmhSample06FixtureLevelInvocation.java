package com.fanhanfei.openjdk;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.*;

/**
 * @author zhangjunshuai
 * @date 2020/7/8
 * @description
 **/
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JmhSample06FixtureLevelInvocation {


    @State(Scope.Benchmark)
    public static class NormalState {
        ExecutorService service;

        @Setup(Level.Trial)
        public void up() {
            service = Executors.newCachedThreadPool();
        }

        @TearDown(Level.Trial)
        public void down() {
            service.shutdown();
        }

    }


    public static class LaggingState extends NormalState {
        public static final int SLEEP_TIME = Integer.getInteger("sleepTime", 10);


        @Setup(Level.Invocation)
        public void lag() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
        }
    }


    @State(Scope.Thread)
    public static class Scratch {
        private double p;

        public double doWork() {
            p = Math.log(p);
            return p;
        }
    }

    public static class Task implements Callable<Double> {
        private Scratch s;

        public Task(Scratch s) {
            this.s = s;
        }

        @Override
        public Double call() {
            return s.doWork();
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public double measureHot(NormalState e, final Scratch s) throws ExecutionException, InterruptedException {
        return e.service.submit(new Task(s)).get();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public double measureCold(LaggingState e, final Scratch s) throws ExecutionException, InterruptedException {
        return e.service.submit(new Task(s)).get();
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample06FixtureLevelInvocation.class.getSimpleName())
                .jvmArgs("-DsleepTime=100")
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
