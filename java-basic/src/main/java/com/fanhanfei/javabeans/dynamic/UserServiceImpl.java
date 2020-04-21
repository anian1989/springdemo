package com.fanhanfei.javabeans.dynamic;

/**
 * @author zhangjunshuai
 * @date 2020/4/21
 * @description
 **/
public class UserServiceImpl implements UserService {

    @Override
    public void select() {
        System.out.println("查询 selectById");
    }
    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
