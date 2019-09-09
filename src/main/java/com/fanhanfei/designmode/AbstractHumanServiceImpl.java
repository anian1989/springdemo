package com.fanhanfei.designmode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjunshuai
 * @date 2019/9/9
 * @description
 **/
@Slf4j
public abstract class AbstractHumanServiceImpl implements HumanService{

    @Override
    public void testAbstract() {
        log.info("公共抽象方法开始");
        this.test();
    }
}
