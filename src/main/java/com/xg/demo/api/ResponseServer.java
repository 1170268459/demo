package com.xg.demo.api;

import javax.persistence.Table;
import java.io.Serializable;


public class ResponseServer<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ResponseServer(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseServer(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseServer(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseServer(int status) {
        this.status = status;
    }

    public static <T> ResponseServer<T> createBySuccess(){
        return new ResponseServer<T>(ResponseCode.SUCCESS.getValue());
    }
    public static <T> ResponseServer<T> createBySuccess(T data){
        return new ResponseServer<T>(ResponseCode.SUCCESS.getValue(),data);
    }
    public static <T> ResponseServer<T> createBySuccess(String message){
        return new ResponseServer<T>(ResponseCode.SUCCESS.getValue(),message);
    }

    public static <T> ResponseServer<T> createBySuccess(String message,T data){
        return new ResponseServer<T>(ResponseCode.SUCCESS.getValue(),message,data);
    }
    public static <T> ResponseServer<T> createBySuccess(int code,String message,T data){
        return new ResponseServer<T>(ResponseCode.SUCCESS.getValue(),message,data);
    }

    public static <T> ResponseServer<T> createByError(){
        return new ResponseServer<T>(ResponseCode.FAIL.getValue());
    }

    public static <T> ResponseServer<T> createByErrorMessage(String errorMassage){
        return new ResponseServer<T>(ResponseCode.FAIL.getValue(),errorMassage);
    }

    public static <T> ResponseServer<T> createByErrorCodeMessage(int code,String errorMassage){
        return new ResponseServer<T>(code,errorMassage);
    }
}
