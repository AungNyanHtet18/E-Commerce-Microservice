package com.dev.anh.order.order;

import org.springframework.stereotype.Service;
import com.dev.anh.order.customer.CustomerClient;
import com.dev.anh.order.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final CustomerClient customerClient;
	
	public Integer createOrder(OrderRequest request) {
		var customer = customerClient.findCustomerById(request.customerId())
				             .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exists with the providied ID."));
		
		return null;
	}

	
}
