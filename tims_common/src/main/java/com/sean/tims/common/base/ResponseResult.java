package com.sean.tims.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult implements Serializable {

    @ApiModelProperty(value = "响应消息", dataType = "String", required = true, example = "操作成功")
    private String message;

    @ApiModelProperty(value = "错误消息")
    private String errorMessage;

    @ApiModelProperty(value = "状态码", dataType = "Integer", required = true, example = "200")
    private Integer responseCode;

    @ApiModelProperty(value = "是否包含错误", dataType = "Boolean", required = true, example = "false")
    private boolean hasError;

    @ApiModelProperty(value = "返回结果数据")
    private Object data;

    public void success() {
        this.responseCode = ResponseStatusCode.SUCCESS;
        this.message = ResponseStatusCode.SUCCESS_MSG;
        this.hasError = false;
    }

    public void success(String msg) {
        this.responseCode = ResponseStatusCode.SUCCESS;
        this.message = msg;
        this.hasError = false;
    }

    public void systemFail(ApplicationException ae) {

        this.responseCode = ae.getErrCode();
        this.message = ae.getMessage();
        this.errorMessage = ae.getErrorMsg();
        this.hasError = true;
    }

}
