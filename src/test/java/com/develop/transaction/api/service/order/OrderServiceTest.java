package com.develop.transaction.api.service.order;

import com.develop.transaction.api.repository.order.OrderJpaRepository;
import com.develop.transaction.api.repository.product.ItemJpaRepository;
import com.develop.transaction.api.service.order.vo.OrderPost;
import com.develop.transaction.domain.order.OrderItem;
import com.develop.transaction.domain.order.OrderResult;
import com.develop.transaction.domain.product.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/***
 * 비즈니스 단위 테스트
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("주문 서비스 테스트")
class OrderServiceUnitTest {

    @Mock
    private ItemJpaRepository itemJpaRepository;

    @Mock
    private OrderJpaRepository orderJpaRepository;

    @InjectMocks
    private OrderService orderService;

    private Item item;

    @BeforeEach
    void setup(){
        // 상품
        item = Item.builder()
                .itemName("Test상품")
                .itemPrc(5000)
                .itemStkQty(10)
                .build();
    }

    @Test
    @DisplayName("일반 상품 주문")
    void orderItemSuccessCase() {
        // given
        // 주문 정보: Item ID가 1이고 주문 수량이 5, 결제 금액은 30000
        OrderPost orderPost =  OrderPost.of(1l,5,30000);

        // 상품 조회
        when(itemJpaRepository.findById(1l)).thenReturn(Optional.of(item));

        // 주문 처리
        orderService.orderItem(orderPost);

        // 수량 10개에서 주문 처리 완료시 5개 반환
        assertEquals(5,item.getItemStkQty());
        verify(orderJpaRepository, times(1)).save(any(OrderItem.class));
    }
}