package com.sean.tims.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ApplicationException extends Exception{
    private Integer errCode;
    private String errorMsg;
}
