package com.dev.anh.order.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.dev.anh.order.orderline.OrderLineResponse;

public record OrderResponse(
	Integer id,
	String reference,
	BigDecimal totalAmount,
	String customerId,
	LocalDateTime createdAt,
	List<OrderLineResponse> orderlines) {

}
