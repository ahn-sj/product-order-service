package org.jae.productorderservice.payment;

import org.jae.productorderservice.order.Order;

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
