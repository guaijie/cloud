package com.example.product.server.exception;

import com.example.product.server.enums.ExceptionEnum;
import lombok.Getter;
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(Integer code, String message){
        super(message);
        this.code=code;
    }

    public ProductException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code=exceptionEnum.getCode();
    }
}
