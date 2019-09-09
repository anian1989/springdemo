package com.fanhanfei.designmode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjunshuai
 * @date 2019/9/9
 * @description
 **/
@Slf4j
@Service("humanServiceImplOne")
public class HumanServiceImplOne extends AbstractHumanServiceImpl {
    @Override
    public void test() {
        log.info("子类一");
    }
}
