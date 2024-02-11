package org.jae.productorderservice.payment.application.port;

import org.jae.productorderservice.order.domain.Order;
import org.jae.productorderservice.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(Long orderId);
    void pay(int totalPrice, String card);
    void save(Payment payment);


}
