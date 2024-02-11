package org.jae.productorderservice.payment.application.service;

public record PaymentRequest(Long orderId, String cardNumber) {
}
