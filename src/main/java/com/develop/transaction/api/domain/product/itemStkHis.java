package com.develop.transaction.api.domain.product;

import com.develop.transaction.api.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_stk_his")
@NoArgsConstructor
@Getter
public class itemStkHis extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_stk_id")
    private Long itemStkId;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "item_stk_qty")
    private Integer itemStkQty;
}
