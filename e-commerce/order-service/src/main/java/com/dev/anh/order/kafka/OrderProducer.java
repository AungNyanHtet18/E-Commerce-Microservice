package com.dev.anh.order.kafka;

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
public class OrderProducer {

	private final KafkaTemplate<String, OrderComfirmation> kafkaTemplate;
	
	public void sendOrderComfirmation(OrderComfirmation orderComfirmation) {
		log.info(String.format("Sending Order Comfirmation :: %s", orderComfirmation.toString()));
	 
		Message<OrderComfirmation> orderMessage = MessageBuilder
				                  .withPayload(orderComfirmation)
				                  .setHeader(KafkaHeaders.TOPIC, "order-topic")
				                  .build();
		
	    kafkaTemplate.send(orderMessage);
	}
	
}
