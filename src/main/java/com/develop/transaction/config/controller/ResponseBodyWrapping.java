package com.develop.transaction.config.controller;

import com.develop.transaction.config.controller.dto.ApiResponseGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * RestControllerEnvelopPattern 어노테이션 한정으로 인한
 * RestControllerAdvice 공통 Response Body Mapping
 */
@RestControllerAdvice(annotations = RestControllerEnvelopPattern.class)
public class ResponseBodyWrapping implements ResponseBodyAdvice<Object> {


    /**
     * 메소드의 반환 제너릭 타입을 가져오기
     * HttpEntity는 HTTP 요청이나 응답의 본문(body)과 헤더(headers)를 함께 담을 수 있는 클래스
     */
    private Type getGenericType(MethodParameter returnType){

        // 1. HttpEntity 또는 그 하위 클래스인 경우
        if(HttpEntity.class.isAssignableFrom(returnType.getParameterType())){
                // ResolvableType을 사용하여 제네릭 타입을 추출
                return ResolvableType.forType(returnType.getGenericParameterType())
                        .getGeneric() // 실제 제너릭 타입을 가져옴
                        .getType();
        }else{
            // 아닌 경우 제너릭 타입 반환
            return returnType.getGenericParameterType();
        }

    }

    /**
     *
     * @param returnType the return type
     * @param converterType the selected converter type
     * @return 응답 가공 여부 설정
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        Type type = GenericTypeResolver.resolveType(
                        getGenericType(returnType), returnType.getContainingClass());

        // void 에서는 가공 x ( 응답이 없으니 )
        if (Void.class.getName().equals(type.getTypeName())) {
            return false;
        }

        // converterType이 byte[] 혹은 resource 컨버터가 아니라면 가공 처리
        return !converterType.isAssignableFrom(ByteArrayHttpMessageConverter.class)
                && !converterType.isAssignableFrom(ResourceHttpMessageConverter.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        // servlet response status
        // 클라이언트(주로 웹 브라우저)로부터의 HTTP 요청을 처리하고, 그에 대한 응답을 생성하기 위해 서버 측에서 실행되는 Java 클래스
        HttpStatus responseStatus =
                HttpStatus.valueOf(
                        ((ServletServerHttpResponse) response).getServletResponse().getStatus());

        if(Objects.isNull(body)){
            return responseStatus.isError()
                    ? ApiResponseGenerator.fail()
                    : ApiResponseGenerator.success();
        }

        var apiResponse =
                responseStatus.isError()
                ? ApiResponseGenerator.fail(body)
                : ApiResponseGenerator.success(body);

        if (selectedConverterType.isAssignableFrom(StringHttpMessageConverter.class)) {
            try {
                response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                return new ObjectMapper().writeValueAsString(apiResponse);
            }  catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }


        return apiResponse;
    }
}
