package org.jae.productorderservice.order;

import org.assertj.core.api.Assertions;
import org.jae.productorderservice.product.DiscountPolicy;
import org.jae.productorderservice.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);

        final int totalPrice = order.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(2000);
    }
}