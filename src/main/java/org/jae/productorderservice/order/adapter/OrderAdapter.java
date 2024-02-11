package org.jae.productorderservice.order.adapter;

import org.jae.productorderservice.order.application.port.OrderPort;
import org.jae.productorderservice.order.domain.Order;
import org.jae.productorderservice.product.domain.Product;
import org.jae.productorderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(final ProductRepository productRepository, final OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품 입니다"));
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
