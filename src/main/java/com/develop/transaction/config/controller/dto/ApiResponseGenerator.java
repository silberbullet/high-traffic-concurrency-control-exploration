package com.develop.transaction.config.controller.dto;

import com.develop.transaction.config.controller.common.BusinessErrorCode;

public class ApiResponseGenerator {

    private static final ApiResponse<Void> SUCCESS = new ApiResponse<>(BusinessErrorCode.SUCCESS);
    private static final ApiResponse<Void> FAILURE = new ApiResponse<>(BusinessErrorCode.BAD_REQUEST);

    /**
     *  성공응답
     */
    public static ApiResponse<Void> success() { return SUCCESS;}

    /**
     * 성공 응답데이터 제공
     */
    public static <D> ApiResponse<D> success(D data){
        return new ApiResponse<>(SUCCESS.getCode(), SUCCESS.getMessage(), data);
    }

    /**
     * 기본적인 실패응답
     */
    public static ApiResponse<Void> fail() {
        return FAILURE;
    }


    /**
     * 실패 응답데이터 제공
     */
    public static <D> ApiResponse<D> fail(D data) {
        return new ApiResponse<>(FAILURE.getCode(), FAILURE.getMessage(), data);
    }

    /**
     * 실패응답
     */
    public static ApiResponse<Void> fail(String code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    /**
     * 응답값 처리(서버에서 응답한 경우는 요청성공(success == true)으로 판단한다)
     */
    public static <D> ApiResponse<D> of(String code, String message, D data) {
        return new ApiResponse<>(code, message, data);
    }
}

