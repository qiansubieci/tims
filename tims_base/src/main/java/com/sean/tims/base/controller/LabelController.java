package com.sean.tims.base.controller;

import com.sean.tims.base.domain.entity.Label;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "标签")
@RequestMapping("/label")
public class LabelController {

    @GetMapping()
    @ApiOperation(value = "获取所有标签信息")
    public List<Label> getLabel(){
        return null;
    }


}
