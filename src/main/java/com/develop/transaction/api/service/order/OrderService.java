package com.develop.transaction.api.service.order;

import com.develop.transaction.api.repository.product.ItemJpaRepository;
import com.develop.transaction.api.service.order.vo.OrderPost;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OrderService {

    private final ItemJpaRepository itemJpaRepository;

    @Transactional
    public void orderItem(OrderPost orderPost) {

        var orderItem = itemJpaRepository.findById(orderPost.getItemId()).orElseThrow(
                () -> new RuntimeException("Order Item Not Found")
        );


    }
}
