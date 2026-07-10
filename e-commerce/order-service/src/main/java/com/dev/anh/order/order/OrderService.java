package com.dev.anh.order.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.dev.anh.order.customer.CustomerClient;
import com.dev.anh.order.exception.BusinessException;
import com.dev.anh.order.kafka.OrderComfirmation;
import com.dev.anh.order.kafka.OrderProducer;
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
	private final OrderProducer orderProducer;
	
	public Integer createOrder(OrderRequest request) {
		var customer = customerClient.findCustomerById(request.customerId())
				             .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exists with the providied ID."));
		
		var purchaseProduct = productClient.purchaseProducts(request.products());
		
		var order = orderRepository.save(orderMapper.mapToOrder(request));
		
		request.products().forEach(orderline -> {
		     orderLineService.saveOrderLine(new OrderLineRequest(
		    		 null,
		    		 order.getId(),
		    		 orderline.productId(),
		    		 orderline.quantity()));
		});
		
		//todo start the payment process
		//send the order confirmation( notification-ms ) 
		orderProducer.sendOrderComfirmation(
				new OrderComfirmation(
					request.reference(), 
					request.amount(), 
					request.paymentMethod(), 
					customer, 
					purchaseProduct));
					
		return order.getId();
	}

	public List<OrderResponse> findAll() {
		return orderRepository.findAll()
				 .stream().map(OrderMapper::mapToOrderResponse).collect(Collectors.toList());
				        
	}

	
}