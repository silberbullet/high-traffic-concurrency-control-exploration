package com.develop.transaction.api.repository.order;


import com.develop.transaction.domain.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 */

public interface OrderJpaRepository extends JpaRepository<OrderItem, Long> {


}