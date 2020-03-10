package com.fanhanfei.springweb.controller;

import com.alibaba.fastjson.JSON;
import com.fanhanfei.springweb.model.UserDTO;
import com.fanhanfei.springweb.model.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
@Controller
@Slf4j
public class OneController {

    @PostMapping("/save/valid")
    public BaseResponse save(@RequestBody @Validated UserDTO userDTO) {
        log.info(JSON.toJSONString(userDTO));
        return BaseResponse.successResponse();
    }
}
