package org.jae.productorderservice.order;

import org.jae.productorderservice.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
class OrderService {

    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping("/orders")
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());
        orderPort.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
