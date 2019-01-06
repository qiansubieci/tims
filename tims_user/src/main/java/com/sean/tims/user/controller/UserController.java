package com.sean.tims.user.controller;

import com.sean.tims.common.base.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * tims
 *
 * @author v-guoshuai
 */
@RestController
@Api(tags = "用户管理")
public class UserController {

    @ApiOperation(value = "获取所有用户")
    @GetMapping("/users")
    public ResponseResult getAllUsers(){

        return new ResponseResult();

    }
}
