package org.jae.productorderservice.payment.application.service;

import org.jae.productorderservice.order.domain.Order;
import org.jae.productorderservice.payment.application.port.PaymentPort;
import org.jae.productorderservice.payment.domain.Payment;
import org.jae.productorderservice.product.domain.DiscountPolicy;
import org.jae.productorderservice.product.domain.Product;

public class PaymentService {

    private PaymentPort paymentPort;

    public void payment(final PaymentRequest request) {
        final Order order = getStubOrder();

        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);
    }

    private Order getStubOrder() {
        return new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
    }
}
