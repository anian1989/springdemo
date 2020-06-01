package com.fanhanfei.springstudy.di.diconfiguration;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
@Data
@ToString
public class ComplexObject {

    private Properties adminEmails;

    private List someList;

    private Map someMap;

    private Set someSet;
}
