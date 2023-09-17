package com.sk.weblog.web.controller;

import com.sk.weblog.common.aspect.ApiOperationLog;
import com.sk.weblog.common.utils.JsonUtil;
import com.sk.weblog.web.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@RestController
@Api(tags = "测试 controller")
public class TestController {

    @PostMapping("/admin/test")
    @ApiOperation("测试接口")
    @ApiOperationLog(description = "测试接口")
    public User test(@RequestBody User user) {
        // 打印入参
        log.info(JsonUtil.toJsonString(user));

        // 设置三种日期字段值
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateDate(LocalDate.now());
        user.setTime(LocalTime.now());
        // 返参
        return user;
    }

}