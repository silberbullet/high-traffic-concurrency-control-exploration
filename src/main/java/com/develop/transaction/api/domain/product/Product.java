package com.develop.transaction.api.domain.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id @GeneratedValue
    @Column(name="prd_id")
    private long id;

    @Column(name="prd_name")
    private String prdName;

    @Column(name="prd_cnt")
    private Integer prdCnt;

    @Column(name="prd_prc")
    private Integer prdPrc;
}
