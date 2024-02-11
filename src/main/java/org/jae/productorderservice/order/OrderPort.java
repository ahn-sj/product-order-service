package org.jae.productorderservice.order;

import org.jae.productorderservice.product.Product;

interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
