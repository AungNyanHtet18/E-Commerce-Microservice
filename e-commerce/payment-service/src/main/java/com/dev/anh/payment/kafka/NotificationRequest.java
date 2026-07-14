package com.dev.anh.payment.kafka;

import java.math.BigDecimal;

import com.dev.anh.payment.payment.PaymentMethod;

public record NotificationRequest(
	String orderReference,
	BigDecimal amount,
	PaymentMethod paymentMethod,
	String customerFirstName,
	String customerLastName,
	String customerEmail) {
}
