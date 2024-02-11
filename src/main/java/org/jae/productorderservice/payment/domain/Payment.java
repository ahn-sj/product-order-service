package org.jae.productorderservice.payment.domain;

import org.jae.productorderservice.order.domain.Order;

public class Payment {
    private Order order;
    private String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
