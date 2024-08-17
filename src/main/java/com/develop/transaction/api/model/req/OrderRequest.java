package com.develop.transaction.api.model.req;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class OrderRequest {

    // 상품코드
    private String slitmCd;
    // 상품명
    private String slitmNm;
    // 상품재고
    private Integer slitmStk;
    // 상품가격
    private Integer slitmPrc;
}
