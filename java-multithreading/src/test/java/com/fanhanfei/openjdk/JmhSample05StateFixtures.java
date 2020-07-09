package com.fanhanfei.openjdk;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
/**
 * @author zhangjunshuai
 * @date 2020/7/8
 * @description
 **/
@State(Scope.Thread)
public class JmhSample05StateFixtures {
    double x;

    /*
     * Since @State objects are kept around during the lifetime of the
     * benchmark, it helps to have the methods which do state housekeeping.
     * These are usual fixture methods, you are probably familiar with them from
     * JUnit and TestNG.
     *
     * Fixture methods make sense only on @State objects, and JMH will fail to
     * compile the test otherwise.
     *
     * As with the State, fixture methods are only called by those benchmark
     * threads which are using the state. That means you can operate in the
     * thread-local context, and (not) use synchronization as if you are
     * executing in the context of benchmark thread.
     *
     * Note: fixture methods can also work with static fields, although the
     * semantics of these operations fall back out of State scope, and obey
     * usual Java rules (i.e. one static field per class).
     */

    /*
     * Ok, let's prepare our benchmark:
     */

    @Setup
    public void prepare() {
        x = Math.PI;
    }

    /*
     * 方法级注解，这个注解的作用就是我们需要在测试之后进行一些结束工作，比如关闭线程池，数据库连接等的，主要用于资源的回收等
     */

    @TearDown
    public void check() {
        assert x > Math.PI : "Nothing changed?";
    }

    /*
     * This method obviously does the right thing, incrementing the field x
     * in the benchmark state. check() will never fail this way, because
     * we are always guaranteed to have at least one benchmark call.
     */

    @Benchmark
    public void measureRight() {
        x++;
    }

    /*
     * This method, however, will fail the check(), because we deliberately
     * have the "typo", and increment only the local variable. This should
     * not pass the check, and JMH will fail the run.
     */

    @Benchmark
    public void measureWrong() {
        double x = 0;
        x++;
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample05StateFixtures.class.getSimpleName())
                .forks(1)
                .jvmArgs("-ea")
                .build();

        new Runner(opt).run();
    }
}
