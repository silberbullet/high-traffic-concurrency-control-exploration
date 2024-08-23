package com.develop.transaction.api.domain.order;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id @GeneratedValue
    @Column(name = "ord_id")
    private long id;

}
