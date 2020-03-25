package com.fanhanfei.pattern.jike.create.factory.di;

import java.io.InputStream;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/3/19
 * @description
 **/
public interface BeanConfigParser {
    List parse(InputStream inputStream);

    List parse(String configContent);
}
