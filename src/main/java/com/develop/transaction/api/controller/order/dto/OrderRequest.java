package com.develop.transaction.api.controller.order.dto;

import com.develop.transaction.api.service.order.vo.OrderPost;
import com.develop.transaction.domain.order.dto.OrderItemDto;

public record OrderRequest(
        long itemId
        , int ordCnt
        , int ordPrc ) {

    public OrderPost toVo() {
        return OrderPost.of(itemId, ordCnt, ordPrc);
    }
}
