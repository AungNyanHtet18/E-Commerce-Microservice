package com.dev.anh.order.orderline;

import org.springframework.stereotype.Service;

import com.dev.anh.order.order.Order;


@Service
public class OrderLineMapper {

	public OrderLine mapToOrderLine(OrderLineRequest request) {
      
		if(request == null) {
			 return null;
		}
		
		return OrderLine.builder()
				     .order( 
				        Order.builder()
				             .id(request.orderId())
				             .build()
				      )
				     .id(request.id())
				     .productId(request.productId())
				     .quantity(request.quantity())
				     .build();
	}

}
