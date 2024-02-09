package org.jae.productorderservice.product;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.jae.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jae.productorderservice.product.ProductSteps.상품등록요청;
import static org.jae.productorderservice.product.ProductSteps.상품등록요청_생성;

/**
 * layer architecture
 * service -> port -> adapter -> repository
 */
public class ProductApiTest extends ApiTest {

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();

        final ExtractableResponse<Response> response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }



}
