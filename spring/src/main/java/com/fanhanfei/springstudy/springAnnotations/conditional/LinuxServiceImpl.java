package com.fanhanfei.springstudy.springAnnotations.conditional;

/**
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
public class LinuxServiceImpl implements OsService {
    @Override
    public String getOsType() {
        return "Linux";
    }
}
