package com.example;

public class Message {
    //0表示成功;-1表示失败
    int status;
    //向前端返回的内容
    String message;
    public Message() {
        super();
    }
    public Message(int status, String massage) {
        super();
        this.status = status;
        this.message = massage;
    }
    //get/set方法
}