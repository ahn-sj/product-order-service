package org.jae.productorderservice.order.application.port;

import org.jae.productorderservice.order.domain.Order;
import org.jae.productorderservice.product.domain.Product;

public interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
