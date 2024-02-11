package org.jae.productorderservice.payment;

import org.jae.productorderservice.order.Order;

public interface PaymentPort {

    Order getOrder(Long orderId);
    void pay(int totalPrice, String card);
    void save(Payment payment);


}
