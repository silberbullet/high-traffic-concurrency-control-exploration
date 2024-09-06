package com.develop.transaction.api.repository.product;

import com.develop.transaction.domain.product.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<Item, Long> {


}
