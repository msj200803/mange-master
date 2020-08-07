package com.stp.result;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.data = data;
        result.code = 200;
        return result;
    }
    public static <T> Result<T> error(T data){
        Result<T> result = new Result<>();
        result.data = data;
        result.code = 500;
        return result;
    }
}
