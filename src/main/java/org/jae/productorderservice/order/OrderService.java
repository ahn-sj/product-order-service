package org.jae.productorderservice.order;

import org.jae.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class OrderService {

    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(final CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());
        orderPort.save(order);
    }
}
