package com.dev.anh.customer.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<String> createCustomer(
			@RequestBody @Valid CustomerRequest request) {
		return ResponseEntity.ok(customerService.createCustomer(request));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Void> updateCustomer(
			 @PathVariable String id, @RequestBody @Valid CustomerRequest request) {
		customerService.updateCustomer(id, request);
		return ResponseEntity.accepted().build();
	}
	
}
