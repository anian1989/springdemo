package com.fanhanfei.openjdk;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjunshuai
 * @date 2020/7/7
 * @description
 * @BenchmarkMode
 *  基准测试类型。这里选择的是Throughput也就是吞吐量。根据源码点进去，每种类型后面都有对应的解释，比较好理解，吞吐量会得到单位时间内可以进行的操作数。
 *
 *  Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
 *  AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
 *  SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
 *  SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
 *  All(“all”, “All benchmark modes”);
 **/
public class JmhSample02BenchmarkModes {
    /*
     * JMH generates lots of synthetic code for the benchmarks for you during
     * the benchmark compilation. JMH can measure the benchmark methods in lots
     * of modes. Users may select the default benchmark mode with a special
     * annotation, or select/override the mode via the runtime options.
     *
     * With this scenario(方案), we start to measure something useful. Note that our
     * payload(装载量) code potentially throws exceptions, and we can just declare them
     * to be thrown. If the code throws the actual exception, the benchmark
     * execution will stop with an error.
     *
     * When you are puzzled with some particular behavior, it usually helps to
     * look into the generated code. You might see the code is doing not
     * something you intend it to do. Good experiments always follow up on the
     * experimental setup, and cross-checking the generated code is an important
     * part of that follow up.
     *
     * The generated code for this particular sample is somewhere at
     * target/generated-sources/annotations/.../JMHSample_02_BenchmarkModes.java
     */

    /*
     * Mode.Throughput, as stated in its Javadoc, measures the raw throughput（吞吐量） by
     * continuously calling the benchmark method in a time-bound iteration, and
     * counting how many times we executed the method.
     *
     * We are using the special annotation to select the units to measure in,
     * although you can use the default.
     */

    @Benchmark
//    Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
//    ops/s 指的是每秒可完成多少个这样的operations请求。
    @BenchmarkMode(Mode.Throughput)
    //计量单位
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void measureThroughput() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /*
     * Mode.AverageTime measures the average execution time, and it does it
     * in the way similar to Mode.Throughput.
     *
     * Some might say it is the reciprocal(彼此相反的) throughput, and it really is.
     * There are workloads where measuring times is more convenient though.
     */

    @Benchmark
//    AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void measureAvgTime() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /*
     * Mode.SampleTime samples the execution time. With this mode, we are
     * still running the method in a time-bound iteration, but instead of
     * measuring the total time, we measure the time spent in *some* of
     * the benchmark method calls.
     *
     * This allows us to infer the distributions, percentiles, etc.
     *
     * JMH also tries to auto-adjust sampling frequency: if the method
     * is long enough, you will end up capturing all the samples.
     */
    @Benchmark
//    SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureSamples() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /*
     * Mode.SingleShotTime measures the single method invocation time. As the Javadoc
     * suggests, we do only the single benchmark method invocation. The iteration
     * time is meaningless in this mode: as soon as benchmark method stops, the
     * iteration is over.
     *
     * This mode is useful to do cold startup tests, when you specifically
     * do not want to call the benchmark method continuously.
     */
    @Benchmark
//    SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureSingleShot() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /*
     * We can also ask for multiple benchmark modes at once. All the tests
     * above can be replaced with just a single test like this:
     */
    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureMultiple() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /*
     * Or even...
     */

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureAll() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You are expected to see the different run modes for the same benchmark.
     * Note the units are different, scores are consistent with each other.
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar JMHSample_02 -f 1
     *    (we requested a single fork; there are also other options, see -h)
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample02BenchmarkModes.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
