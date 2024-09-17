package com.develop.transaction.domain.product;

import com.develop.transaction.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 *  1) Setter는 사용하지 않기
 *
 *  객체가 언제든지 변경할 수 있는 상태가 되어 영속성 보장이 힘들고
 *  해당 변경 가능성 어디서 누구에 의해 발생했는지 추적하기 힘듬
 *
 *  2) NoArgsConstructor 접근 제어를 Protected로 설정하면 아무런 값도 갖지 않는 의미 없는 객체 생성 방지
 *  3) AllArgsConstructor은 인스턴스 멤버의 선언 순서에 영향을 받기에 변수의 순서를 바꾸면 생성자의 입력값 순서에도 치명적 오류 발생
 */
@Entity
@Table(name = "item")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
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

    @Builder
    public Item(String itemName, Integer itemStkQty, Integer itemPrc) {
        this.itemName = itemName;
        this.itemStkQty = itemStkQty;
        this.itemPrc = itemPrc;
    }

    public void updateItemStkQty(Integer itemStkQty) {
        this.itemStkQty = itemStkQty;
    }
}
