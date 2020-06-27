package com.bl.demo.model;

public class Response {
    String message;
    Object data;
    Integer statusCode;

    public Response(String message, Object data, Integer statusCode) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}