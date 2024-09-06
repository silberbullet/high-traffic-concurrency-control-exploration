package com.develop.transaction.api.service.order.vo;

import lombok.Getter;

@Getter
public class OrderPost {

    private Long ItemId;
    private Integer ordCnt;
    private Integer ordPrc;

    public OrderPost(Long ItemId, Integer ordCnt, Integer ordPrc) {
        this.ItemId = ItemId;
        this.ordCnt = ordCnt;
        this.ordPrc = ordPrc;
    }

    public static OrderPost of(Long ItemId, Integer ordCnt, Integer ordPrc) {
        return new OrderPost(ItemId, ordCnt, ordPrc);
    }
}
