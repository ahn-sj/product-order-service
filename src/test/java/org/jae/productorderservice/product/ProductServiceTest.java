package org.jae.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품 수정")
    void 상품_수정() {

        // given:
        final Long productId = 1L;
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

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
