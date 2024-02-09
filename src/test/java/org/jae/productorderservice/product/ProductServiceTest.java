package org.jae.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품 수정")
    void 상품_수정() {
        // given:
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        // when:
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        productService.updateProduct(productId, request);

        // then:
        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();
        Assertions.assertThat(productResponse.name()).isEqualTo("상품 수정");
        Assertions.assertThat(productResponse.price()).isEqualTo(2000);
    }

}
