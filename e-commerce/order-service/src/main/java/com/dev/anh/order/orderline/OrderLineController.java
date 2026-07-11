package com.dev.anh.order.orderline;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orderline")
@RequiredArgsConstructor
public class OrderLineController {
    
	private final OrderLineService orderLineService;
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<List<OrderLineResponse>> findAllByOrderId(@PathVariable Integer orderId) {
		 return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId));
	}
	
}
