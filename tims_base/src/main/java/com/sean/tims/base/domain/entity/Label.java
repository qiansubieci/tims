package com.sean.tims.base.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Label implements Serializable {

    private String id;
    private String labelName;
    private String state;
    private Integer count;
    private String recommend;
    private Integer fans;
}
