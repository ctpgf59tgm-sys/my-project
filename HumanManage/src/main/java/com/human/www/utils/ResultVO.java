package com.human.www.utils;

public class ResultVO<T> {
    private static final Integer SUCCESS=200;
    private static final Integer ERROR=400;

    private Integer code;
    private String message;
    private T data;

    //
    //成功返回值，全参
    private ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //错误返回值
    private ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    //定义一个静态方法，用来返回正确的返回值信息
    public static <T> ResultVO<T> success(String message,T data){
        ResultVO<T> resultVO = new ResultVO<T>(SUCCESS,message,data);
        return  resultVO;
    }
    //定义一个静态方法,用来返回错误的返回值
    public static <T> ResultVO<T> error(String message){
        ResultVO<T> resultVO = new ResultVO<T>(ERROR,message);
        return resultVO;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
