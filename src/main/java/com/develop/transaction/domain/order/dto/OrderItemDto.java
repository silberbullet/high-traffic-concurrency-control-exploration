package com.develop.transaction.domain.order.dto;

import com.develop.transaction.domain.order.OrderItem;
import com.develop.transaction.domain.product.Item;

public record OrderItemDto (Item item, Integer ordCnt) {

    public static OrderItemDto from (OrderItem orderItem) {
        return new OrderItemDto(orderItem.getItem(), orderItem.getOrdCnt());
    }
}
