package com.sean.tims.base.controller;

import com.sean.tims.common.base.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "标签")
@RequestMapping("/label")
public class LabelController {

    @GetMapping()
    @ApiOperation(value = "获取所有标签信息")
    public ResponseResult getLabel(){

        return new ResponseResult();
    }
    
}
