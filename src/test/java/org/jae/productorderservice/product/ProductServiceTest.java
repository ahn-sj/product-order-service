package org.jae.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private StubProductPort productPort = new StubProductPort();;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품 수정")
    void 상품_수정() {

        // given:
        final Long productId = 1L;
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        productPort.getProduct_will_return = product;

        // when:
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        productService.updateProduct(productId, request);

        // then:
        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);


    }

    private static class StubProductPort implements ProductPort {

        public Product getProduct_will_return;

        @Override
        public void save(final Product product) {

        }

        @Override
        public Product getProduct(final Long productId) {
            return getProduct_will_return;
        }
    }
}
