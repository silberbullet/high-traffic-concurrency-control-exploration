package com.develop.transaction.config.controller;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;


/**
 * 봉투패턴을 사용하는 API Controller 에 {@link org.springframework.web.bind.annotation.RestController} 를 대체하여 선언합니다.
 * [어노테이션 설명]
 * Target : 이 어노테이션이 적용될 수 있는 요소를 정의합니다. ElementType.TYPE은 클래스, 인터페이스(애너테이션 포함), 열거형에 적용될 수 있음을 의미
 * Retention(RetentionPolicy.RUNTIME) :  어노테이션이 얼마나 오래 유지될지를 정의, RetentionPolicy.RUNTIME은 런타임 동안 이 어노테이션이 유지된다는 것을 의미
 * Documented : Javadoc 같은 문서화 도구에서 문서화되어야 함, 래스나 인터페이스가 Javadoc에서 보여질 때, 이 어노테이션도 함께 문서화
 * Inherited : 어노테이션이 상속될 수 있음을 의미
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@RestController
public @interface RestControllerEnvelopPattern {

}
