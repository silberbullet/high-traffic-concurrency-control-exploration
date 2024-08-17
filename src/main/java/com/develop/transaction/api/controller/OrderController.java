package com.develop.transaction.api.controller;

import com.develop.transaction.config.controller.RestControllerEnvelopPattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.transaction.api.model.req.OrderRequest;
import com.develop.transaction.api.model.res.OrderResponse;
import com.develop.transaction.api.service.OrderService;

import lombok.RequiredArgsConstructor;

/**
 * 주문 담당 컨트롤러
 *
 * @author gyeongwooPark
 * @version 1.0
 * @since 2024.07.
 */
@RequiredArgsConstructor
@RestControllerEnvelopPattern
@RequestMapping("/api/v1/ord")
public class OrderController {

    private final OrderService orderService;

    /**
     * 상품 조회
     */
    @GetMapping("/select-slitm")
    public OrderResponse selectSlitm(OrderRequest orderRequest) {

        return orderService.selectSlitm(orderRequest);
    }

    /**
     * 일반 상품 주문
     */
    @PostMapping("/order-slitm")
    public void OrderSlitm(OrderRequest orderRequest) {
    }

    /**
     * Serializable + 배타 락 상품 주문
     */
    @PostMapping("/order-slitm-lock")
    public void OrderSlitmLock(OrderRequest orderRequest) {

    }

    /**
     * Repatable-Read + Version 상품 주문
     */
    @PostMapping("/order-slitm-version")
    public void OrderSlitmVersion(OrderRequest orderRequest) {

    }
}
