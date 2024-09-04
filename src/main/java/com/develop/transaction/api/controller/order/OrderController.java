package com.develop.transaction.api.controller.order;

import com.develop.transaction.api.controller.order.dto.OrderRequest;
import com.develop.transaction.api.service.order.OrderService;
import com.develop.transaction.config.controller.RestControllerEnvelopPattern;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * 일반 상품 주문
     */
    @PostMapping("/order-slitm")
    public void OrderSlitm(OrderRequest orderRequest) {

    }
//
//    /**
//     * Serializable + 배타 락 상품 주문
//     */
//    @PostMapping("/order-slitm-lock")
//    public void OrderSlitmLock(OrderRequest orderRequest) {
//
//    }
//
//    /**
//     * Repatable-Read + Version 상품 주문
//     */
//    @PostMapping("/order-slitm-version")
//    public void OrderSlitmVersion(OrderRequest orderRequest) {
//
//    }
}
