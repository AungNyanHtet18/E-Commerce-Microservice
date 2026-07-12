package com.dev.anh.payment.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.dev.anh.payment.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentProducer {

	private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;
	
	public void sendPaymentComfirmation(PaymentNotificationRequest paymentNotificationRequest) {
		 log.info(String.format("Sending Payment Notification :: %s", paymentNotificationRequest.toString()));
	
		 Message<PaymentNotificationRequest> paymentMessage = MessageBuilder
				                                               .withPayload(paymentNotificationRequest)
				                                               .setHeader(KafkaHeaders.TOPIC, "payment-topic")
				                                               .build();
		 kafkaTemplate.send(paymentMessage);
	}
	
	
}
