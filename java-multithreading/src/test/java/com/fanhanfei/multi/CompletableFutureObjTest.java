package com.fanhanfei.multi;

import com.fanhanfei.multithreading.CompletableFutureObj;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author zhangjunshuai
 * @date 2020/4/16
 * @description
 **/
public class CompletableFutureObjTest {
    @Test
    @DisplayName("串行")
    public void test(){
        CompletableFutureObj completableFutureObj = new CompletableFutureObj();
        completableFutureObj.thenApply();
    }
    @Test
    @DisplayName("Or")
    public void testOr(){
        CompletableFutureObj completableFutureObj = new CompletableFutureObj();
        completableFutureObj.or();
    }
}
