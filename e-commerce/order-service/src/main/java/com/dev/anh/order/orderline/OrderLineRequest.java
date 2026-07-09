package com.dev.anh.order.orderline;

public record OrderLineRequest(
	Integer id, 
	Integer orderId,
	Integer productId,
	double quantity) {

}