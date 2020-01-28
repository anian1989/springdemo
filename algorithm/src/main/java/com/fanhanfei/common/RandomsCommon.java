package com.fanhanfei.common;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author zhangjunshuai
 * @date 2020/1/28
 * @description 一些随机数的学习
 **/
public class RandomsCommon {

    public static Integer randomIntFromMath(int min,int max){
        int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
        return randomWithMathRandom;
    }

    public static Integer randomIntFromRandom(int min,int max){
        Random random = new Random();
        return random.nextInt(max-min)+min;
    }

    public static Integer randomIntFromIntStream(int min,int max){
        Random random = new Random();
        IntStream ints = random.ints(1L, min, max);
        return ints.findFirst().getAsInt();
    }

    public static Integer randomIntFromThreadLocalRandom(int min,int max){
        int randomWithThreadLocalRandomInARange = ThreadLocalRandom.current().nextInt(min, max);
        return randomWithThreadLocalRandomInARange;
    }

    public static Integer randomIntFromSplittableRandom(int min,int max){
        SplittableRandom splittableRandom = new SplittableRandom();
        int i = splittableRandom.nextInt(min, max);
        return i;
    }
}
