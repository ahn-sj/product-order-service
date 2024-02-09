package org.jae.productorderservice.product;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.jae.productorderservice.ApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * layer architecture
 * service -> port(interface) -> adapter(impl) -> repository
 */
public class ProductApiTest extends ApiTest {

    @Test
    void 상품등록() {
        final AddProductRequest request = ProductSteps.상품등록요청_생성();

        final ExtractableResponse<Response> response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("상품 조회")
    void 상품_조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final ExtractableResponse<Response> response = ProductSteps.상품조회요청(productId);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }


}
