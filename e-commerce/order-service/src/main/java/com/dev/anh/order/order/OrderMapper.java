package com.dev.anh.order.order;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.anh.order.orderline.OrderLineMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderMapper {
	
	public Order mapToOrder(OrderRequest request) {

		if(request == null) {
			return null;
		}
		
		return Order.builder()
				    .id(request.id())
				    .reference(request.reference())
				    .totalAmount(request.amount())
				    .paymentMethod(request.paymentMethod())
				    .customerId(request.customerId())
				    .build();
	}
	
	public static OrderResponse mapToOrderResponse(Order order) {
		
		var orderlines = order.getOrderLines().stream().map(OrderLineMapper::mapToOrderLine).collect(Collectors.toList());
		
		return new OrderResponse(
				 order.getId(), 
				 order.getReference(), 
				 order.getTotalAmount(), 
				 order.getCustomerId(), 
				 order.getCreatedAt(),
				 orderlines
				 );
	}

	
	
}
