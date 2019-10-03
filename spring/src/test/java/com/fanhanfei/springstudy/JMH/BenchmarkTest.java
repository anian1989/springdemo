package com.fanhanfei.springstudy.JMH;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zhangjunshuai
 * warmupIterations(10)的意思是预热做10轮，
 * measurementIterations(10)代表正式计量测试做10轮，
 * 而每次都是先执行完预热再执行正式计量，内容都是调用标注了@Benchmark的代码。
 * @date 2019/5/29
 * @description
 **/

/**
 * 名称	                    描述
 * Mode.Throughput	    计算一个时间单位内操作数量
 * Mode.AverageTime	    计算平均运行时间
 * Mode.SampleTime	    计算一个方法的运行时间(包括百分位)
 * Mode.SingleShotTime	方法仅运行一次(用于冷测试模式)。或者特定批量大小的迭代多次运行(具体查看后面的“`@Measurement“`注解)——这种情况下JMH将计算批处理运行时间(一次批处理所有调用的总时间)
 *                      这些模式的任意组合	可以指定这些模式的任意组合——该测试运行多次(取决于请求模式的数量)
 * Mode.All	            所有模式依次运行
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
/***
 * State 注解定义了给定类实例的可用范围。JMH可以在多线程同时运行的环境测试，因此需要选择正确的状态。
 名称	        描述
 Scope.Thread	默认状态。实例将分配给运行给定测试的每个线程。
 Scope.Benchmark	运行相同测试的所有线程将共享实例。可以用来测试状态对象的多线程性能(或者仅标记该范围的基准)。
 Scope.Group	实例分配给每个线程组(查看后面的线程组部分)
 *
 */

@State(Scope.Benchmark)
@Slf4j
public class BenchmarkTest {/*
    *//***
     * JMH使用所有@Param字段的输出结果。因此，如果第一个字段有2个参数，第二个字段有5个参数，测试将运行2 * 5 * Forks次。
     *//*
    @Param({"10000","1000"})
    private int length;

    private int[] numbers;
    private Calculator singleThreadCalc;
    private Calculator multiThreadCalc;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                //启用线程数
                .forks(2)
                //预热次数
                .warmupIterations(2)
        //        实际测量的迭代次数
                .measurementIterations(3)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public long singleThreadBench() {
        return singleThreadCalc.sum(numbers);
    }

    @Benchmark
    public long multiThreadBench() {
        return multiThreadCalc.sum(numbers);
    }

    *//**
     * @Setup/@TearDown 注解使用Level参数来指定何时调用fixture：
     *
     * 名称               描述
     * Level.Trial	    默认level。全部benchmark运行(一组迭代)之前/之后
     * Level.Iteration	一次迭代之前/之后(一组调用)
     * Level.Invocation	每个方法调用之前/之后(不推荐使用，除非你清楚这样做的目的)
     *//*
    @Setup
    public void prepare() {
        System.out.println("测试开始");
        numbers = IntStream.rangeClosed(1, length).toArray();
        singleThreadCalc = new SinglethreadCalculator();
        multiThreadCalc = new MultithreadCalculator(Runtime.getRuntime().availableProcessors());
    }

    @TearDown
    public void shutdown() {
        System.out.println("测试结束");
        singleThreadCalc.shutdown();
        multiThreadCalc.shutdown();
    }*/
}
