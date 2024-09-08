package com.develop.transaction.api.service.order.vo;

import com.develop.transaction.domain.order.OrderResult;
import com.develop.transaction.domain.order.OrderItem;
import com.develop.transaction.domain.product.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderPost {

    private Long ItemId;
    private Integer ordCnt;
    private Integer ordPrc;

    public static OrderPost of(Long ItemId, Integer ordCnt, Integer ordPrc) {
        return new OrderPost(ItemId, ordCnt, ordPrc);
    }

    public OrderItem create(Item item, OrderResult status) {
        return OrderItem.builder()
                .item(item)
                .ordCnt(ordCnt)
                .ordPrc(ordPrc)
                .orderResult(status)
                .build();
    }
}
