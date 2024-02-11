package org.jae.productorderservice.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.jae.productorderservice.ApiTest;
import org.jae.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class OrderApiTest extends ApiTest {

    @Test
    void 상품_주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 생성주문요청_생성();

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
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
