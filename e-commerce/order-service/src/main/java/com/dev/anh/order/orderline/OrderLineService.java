package com.dev.anh.order.orderline;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderLineService {

	private final OrderLineRepository orderLineRepository;
	private final OrderLineMapper orderLineMapper;
	
	public Integer saveOrderLine(OrderLineRequest orderlineRequest) {
		var orderLine = orderLineMapper.mapToOrderLine(orderlineRequest);
		return orderLineRepository.save(orderLine).getId();
	}
	
	
	
}
