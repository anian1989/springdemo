package com.fanhanfei.validator.test;

import com.fanhanfei.springweb.common.ValidatorDefault;
import com.fanhanfei.springweb.model.UserDTO;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @author zhangjunshuai
 * @date 2020/2/23
 * @description
 **/
@DisplayName("校验测试")
public class ValidatorDefaultTest {

    @DisplayName("Hibernate实现器")
    @Test
    public void first(){
        UserDTO userDTO = new UserDTO();
        ValidatorDefault.getInstance().validate(userDTO);

    }

    @DisplayName("Spring 的实现器")
    @Test
    public void second(){
        boolean empty = CollectionUtils.isEmpty(Collections.emptyList());
        System.out.println(empty);
    }
}
