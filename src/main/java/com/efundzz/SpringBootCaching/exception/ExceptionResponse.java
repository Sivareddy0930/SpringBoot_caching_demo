package com.efundzz.SpringBootCaching.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    private String timestamp;
    private int statusCode;

    private String message;
//    private String path;


    public ExceptionResponse(String timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.statusCode = status;
        this.message = message;
//        this.path = path;
    }

}
