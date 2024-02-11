package org.jae.productorderservice.product.application.port;

import org.jae.productorderservice.product.domain.Product;

public interface ProductPort {
    void save(final Product product);
    Product getProduct(final Long productId);

}
