package org.jae.productorderservice.order;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.jae.productorderservice.ApiTest;
import org.jae.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class OrderApiTest extends ApiTest {

    @Test
    void 상품_주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = ProductSteps.생성주문요청_생성();

        final ExtractableResponse<Response> response = ProductSteps.상품주문요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
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
