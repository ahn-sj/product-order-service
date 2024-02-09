package org.jae.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품 조회")
    void 상품_조회() {

        // given: 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        // when: 상품 조회
        final GetProductResponse response = productService.getProduct(productId);

        // then: 상품 검증
        Assertions.assertThat(response).isNotNull();
    }

}
