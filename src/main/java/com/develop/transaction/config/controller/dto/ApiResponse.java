package com.develop.transaction.config.controller.dto;


import com.develop.transaction.config.controller.common.BusinessErrorCode;

/**
 * API Response 정의
 * 봉투 패턴 구조로 정의
 * @param <T>
 */
public class ApiResponse <T>{

    private String code;
    private String message;
    private T data;

    protected ApiResponse() {}

    public ApiResponse(BusinessErrorCode businessErrorCode) {
        this.code = businessErrorCode.getCode();
        this.message = businessErrorCode.getMessage();
    }

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {return code;}

    public String getMessage() {return message;}

    public T getData() {return data;}
}
