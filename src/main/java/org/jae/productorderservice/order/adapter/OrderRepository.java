package org.jae.productorderservice.order.adapter;

import org.jae.productorderservice.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
