package com.fanhanfei.openjdk;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
/**
 * @author zhangjunshuai
 * @date 2020/7/7
 * @description
 **/
@State(Scope.Benchmark)
public class JmhSample04DefaultStates {
    double x = Math.PI;

    @Benchmark
    public void measure() {
        x++;
        System.out.println("thread name:"+Thread.currentThread().getName());
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You can see the benchmark runs as usual.
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar JMHSample_04 -f 1
     *    (we requested single fork; there are also other options, see -h)
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample04DefaultStates.class.getSimpleName())
                .output("04DefaultStates.txt")
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
