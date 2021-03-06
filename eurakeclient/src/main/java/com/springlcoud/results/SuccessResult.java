package com.springlcoud.results;

public class SuccessResult<T> extends Result {

    public SuccessResult(T data, String message){
        this.status=1;
        this.message=message;
        this.data=data;
    }
    public SuccessResult(T data){
        this.status=1;
        this.message="success";
        this.data=data;
    }
    public SuccessResult(){
        this.status=1;
        this.message="success";
        this.data=1;
    }
}