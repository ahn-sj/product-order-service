package org.jae.productorderservice.order;

import org.jae.productorderservice.product.ProductService;
import org.jae.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Test
    void 상품_주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 생성주문요청_생성();

        orderService.createOrder(request);
    }

    private static CreateOrderRequest 생성주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;

        return new CreateOrderRequest(productId, quantity);
    }

//    private class StubOrderPort implements OrderPort {
//        @Override
//        public Product getProductById(final Long productId) {
//            return new Product("상품명", 1000, DiscountPolicy.NONE);
//        }
//
//        @Override
//        public void save(final Order order) {
//            orderRepository.save(order);
//        }
//    }
}
