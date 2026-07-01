package com.dev.anh.customer.customer;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	ResponseEntity<List<CustomerResponse>> findAll() {
		 return ResponseEntity.ok(customerService.findAll());
	}
	
	@GetMapping("/exist/{customerId}")
	ResponseEntity<Boolean> existById(@PathVariable String customerId) {
		 return ResponseEntity.ok(customerService.existsById(customerId));
	}
	
	@GetMapping("/{customerId}")
	ResponseEntity<CustomerResponse> findById(@PathVariable String customerId) {
		 return ResponseEntity.ok(customerService.findById(customerId));
	}
	
	@PostMapping
    ResponseEntity<String> createCustomer(
			@RequestBody @Valid CustomerRequest request) {
		return ResponseEntity.ok(customerService.createCustomer(request));
	}
	
	@PutMapping("{customerId}")
	ResponseEntity<Void> updateCustomer(
			 @PathVariable String customerId, @RequestBody @Valid CustomerRequest request) {
		customerService.updateCustomer(customerId, request);
		return ResponseEntity.accepted().build();
	}	
	
	@DeleteMapping("{customerId}")
	ResponseEntity<Void> deleteCustomerById(
     		@PathVariable String customerId) {
		 customerService.deleteCustomerById(customerId);
	    return ResponseEntity.accepted().build();
	}
	
}
