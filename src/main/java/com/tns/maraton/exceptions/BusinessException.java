package com.tns.maraton.exceptions;

import java.io.IOException;

public class BusinessException extends RuntimeException {

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Exception e){
        super(message, e);
    }

}
