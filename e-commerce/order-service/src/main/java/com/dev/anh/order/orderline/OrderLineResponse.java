package com.dev.anh.order.orderline;

public record OrderLineResponse(
	Integer id,
	Integer productId,
	double quantity) {

}