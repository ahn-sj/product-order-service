package org.jae.productorderservice.payment.adapter;

import org.jae.productorderservice.order.domain.Order;
import org.jae.productorderservice.payment.domain.Payment;
import org.jae.productorderservice.payment.application.port.PaymentPort;
import org.jae.productorderservice.product.domain.DiscountPolicy;
import org.jae.productorderservice.product.domain.Product;

public class PaymentAdapter implements PaymentPort {

    private PaymentRepository paymentRepository;
    private PaymentGateway paymentGateway;

    @Override
    public Order getOrder(final Long orderId) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);

    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }

    private class PaymentRepository {
        public void save(final Payment payment) {
            System.out.println("call save");
        }
    }

    private class PaymentGateway {

        public void execute(final int totalPrice, final String cardNumber) {
            System.out.println("PG call" + totalPrice + "card Number = " + cardNumber);
        }
    }
}
