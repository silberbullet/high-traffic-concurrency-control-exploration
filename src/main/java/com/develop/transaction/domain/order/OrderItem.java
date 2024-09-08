package com.develop.transaction.domain.order;

import com.develop.transaction.domain.BaseEntity;
import com.develop.transaction.domain.product.Item;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
// 기본 생성자의 접근 제어를 PROTECTED로 설정을 통해 값이 없는 의미 없는 객체 생성 방지
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderItem extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name="ord_cnt", nullable = false)
    private Integer ordCnt;

    @Column(name="ord_prc", nullable = false)
    private Integer ordPrc;

    @Enumerated(EnumType.STRING)
    private OrderResult orderResult;

    @Builder
    public OrderItem(Item item, Integer ordCnt, Integer ordPrc, OrderResult orderResult) {
        this.item = item;
        this.ordCnt = ordCnt;
        this.ordPrc = ordPrc;
        this.orderResult = orderResult;
    }
}


