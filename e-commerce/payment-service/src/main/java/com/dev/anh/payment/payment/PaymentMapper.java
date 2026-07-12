package com.dev.anh.payment.payment;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentMapper {

	public Payment mapToPayment(PaymentRequest request) {
		return Payment.builder()
				     .id(request.id())
				     .orderId(request.orderId())
				     .amount(request.amount())
				     .paymentMethod(request.paymentMethod())
				     .build();
	}
	
	
}
