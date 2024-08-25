package com.develop.transaction.api.domain.product;

import com.develop.transaction.api.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@NoArgsConstructor
@Getter
public class Item extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private long id;

    @Column(name="item_name", nullable = false, length = 100)
    private String itemName;

    @Column(name="item_stk_qty", nullable = false)
    private Integer itemStkQty;

    @Column(name="item_prc", nullable = false)
    private Integer itemPrc;

}
