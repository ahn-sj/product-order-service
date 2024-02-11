package org.jae.productorderservice.payment;

import org.jae.productorderservice.order.Order;
import org.jae.productorderservice.product.DiscountPolicy;
import org.jae.productorderservice.product.Product;

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
