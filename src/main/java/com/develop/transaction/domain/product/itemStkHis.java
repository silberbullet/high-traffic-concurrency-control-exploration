package com.develop.transaction.domain.product;

import com.develop.transaction.domain.BaseEntity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "item_stk_qty")
    private Integer itemStkQty;
}
