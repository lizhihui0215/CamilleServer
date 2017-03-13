package com.camille.model;

import java.util.ArrayList;

/**
 * Created by lizhihui on 09/02/2017.
 */
public class ResponseObject<T> {
    public Integer code;
    public String message;
    public T result;

    public ResponseObject(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
