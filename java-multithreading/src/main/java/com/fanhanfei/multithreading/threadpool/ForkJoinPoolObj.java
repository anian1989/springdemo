package com.fanhanfei.multithreading.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author zhangjunshuai
 * @date 2020/4/15
 * @description 学习forkjoin线程池
 **/
public class ForkJoinPoolObj {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       ForkJoinPool forkJoinPool = new ForkJoinPool();
        for (int i=0;i<10;i++){
            ForkJoinTask<Integer> submit = forkJoinPool.submit(new Fibonacci(i));
            System.out.println(submit.get());
        }
    }
}
class Fibonacci extends RecursiveTask<Integer>{
    private Integer n;

    public Fibonacci(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1){
            return n;
        }
        Fibonacci fibonacci = new Fibonacci(n - 1);
        fibonacci.fork();
        Fibonacci fibonacci1 = new Fibonacci(n - 2);
        fibonacci1.fork();
        return fibonacci.join()+fibonacci1.join();
    }
}
