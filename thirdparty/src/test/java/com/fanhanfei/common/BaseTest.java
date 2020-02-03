package com.fanhanfei.common;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author zhangjunshuai
 * @date 2019/11/1
 * @description
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { ThirdPartyApplication.class })
public class BaseTest {
}
