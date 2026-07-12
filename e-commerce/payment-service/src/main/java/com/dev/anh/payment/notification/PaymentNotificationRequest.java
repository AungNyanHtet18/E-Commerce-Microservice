package com.dev.anh.payment.notification;

import java.math.BigDecimal;

import com.dev.anh.payment.payment.PaymentMethod;

public record PaymentNotificationRequest(
	String orderReference,
	BigDecimal amount,
	PaymentMethod paymentMethod,
	String customerFirstName,
	String customerLastName,
	String customerEmail) {

}
