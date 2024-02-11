package org.jae.productorderservice.payment;

public record PaymentRequest(Long orderId, String cardNumber) {
}
