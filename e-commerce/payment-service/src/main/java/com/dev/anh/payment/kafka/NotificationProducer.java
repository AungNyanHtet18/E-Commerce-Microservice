package com.dev.anh.payment.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

	private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;
	
	public void sendPaymentComfirmation(NotificationRequest notificationRequest) {
		 log.info(String.format("Sending Payment Notification :: %s", notificationRequest.toString()));
	
		 Message<NotificationRequest> paymentMessage = MessageBuilder
				                        .withPayload(notificationRequest)
				                        .setHeader(KafkaHeaders.TOPIC, "payment-topic")
				                        .build();
		 
		 kafkaTemplate.send(paymentMessage);
	}
	
	
}
