package com.develop.transaction.api.service.order;

import com.develop.transaction.api.repository.order.OrderJpaRepository;
import com.develop.transaction.api.repository.product.ItemJpaRepository;
import com.develop.transaction.api.service.order.vo.OrderPost;
import com.develop.transaction.domain.order.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OrderService {

    private final ItemJpaRepository itemJpaRepository;
    private final OrderJpaRepository orderJpaRepository;

    /**
     * 일반적인 상품 주문
     * @param orderPost
     */
    @Transactional
    public void orderItem(OrderPost orderPost) {

        var orderItem = itemJpaRepository.findById(orderPost.getItemId()).orElseThrow(
                () -> new RuntimeException("Order Item Not Found")
        );

        // 재고 확인
        if(orderItem.getItemStkQty() < orderPost.getOrdCnt()){
            // 주문 실패
            orderJpaRepository.save(orderPost.create(orderItem, OrderStatus.FAIL));
            throw new RuntimeException("Out of item stock");
        }

        // 주문 처리
        orderItem.setItemStkQty(orderItem.getItemStkQty() - orderPost.getOrdCnt());

        // 주문 성공
        orderJpaRepository.save(orderPost.create(orderItem,OrderStatus.SUCCESS));
    }
}
