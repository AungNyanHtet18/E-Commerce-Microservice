package com.dev.anh.order.order;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest request) {
		 return ResponseEntity.ok(orderService.createOrder(request));
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponse>> findAll() {
		 return ResponseEntity.ok(orderService.findAll());
	}
	
	
}
