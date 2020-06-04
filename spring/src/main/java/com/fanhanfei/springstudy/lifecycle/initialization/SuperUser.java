package com.fanhanfei.springstudy.lifecycle.initialization;

import lombok.Data;
import lombok.ToString;

/**
 * @author zhangjunshuai
 * @date 2020/6/4
 * @description
 **/
@Super
@Data
@ToString(callSuper = true)
public class SuperUser extends User {

    private String address;
}
