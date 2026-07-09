package com.dev.anh.order.order;

import org.springframework.stereotype.Service;
import com.dev.anh.order.customer.CustomerClient;
import com.dev.anh.order.exception.BusinessException;
import com.dev.anh.order.orderline.OrderLineMapper;
import com.dev.anh.order.orderline.OrderLineRepository;
import com.dev.anh.order.orderline.OrderLineRequest;
import com.dev.anh.order.orderline.OrderLineService;
import com.dev.anh.order.product.ProductClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;
	private final OrderLineService orderLineService;

	private final CustomerClient customerClient;
	private final ProductClient productClient;
	
	public Integer createOrder(OrderRequest request) {
		var customer = customerClient.findCustomerById(request.customerId())
				             .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exists with the providied ID."));
		
		productClient.purchaseProducts(request.products());
		
		var order = orderRepository.save(orderMapper.mapToOrder(request));
		
		request.products().forEach(orderline -> {
		     orderLineService.saveOrderLine(new OrderLineRequest(
		    		 null,
		    		 order.getId(),
		    		 orderline.productId(),
		    		 orderline.quantity()));
		});
				
		return order.getId();
	}

	
}