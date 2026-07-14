package com.dev.anh.payment.payment;

import org.springframework.stereotype.Service;

import com.dev.anh.payment.kafka.NotificationProducer;
import com.dev.anh.payment.kafka.NotificationRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
	private NotificationProducer notificationProducer;
    
	public Integer createPayment(PaymentRequest request) {
		var payment = paymentRepository.save(paymentMapper.mapToPayment(request));
		
		notificationProducer.sendPaymentComfirmation(
				 new NotificationRequest(
						request.orderReference(), 
						request.amount(), 
						request.paymentMethod(), 
						request.customer().firstName(), 
						request.customer().lastName(),
						request.customer().email()));
		
		return payment.getId();
	}
	
	
	
	
}
