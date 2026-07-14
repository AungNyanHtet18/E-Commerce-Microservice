package com.dev.anh.payment.payment;

import java.math.BigDecimal;

public record PaymentRequest(
	Integer orderId,
	BigDecimal amount,
    PaymentMethod paymentMethod,
    String orderReference,
    Customer customer) {
}