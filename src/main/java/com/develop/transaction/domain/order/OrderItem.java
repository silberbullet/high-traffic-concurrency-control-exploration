package com.develop.transaction.domain.order;

import com.develop.transaction.domain.BaseEntity;
import com.develop.transaction.domain.product.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
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
    private OrderStatus orderStatus;

}

enum OrderStatus{
    SUCCESS, FAIL
}
