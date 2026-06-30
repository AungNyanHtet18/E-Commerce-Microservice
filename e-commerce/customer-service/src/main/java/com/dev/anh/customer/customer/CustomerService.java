package com.dev.anh.customer.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper; 
	
	@Transactional
	public String createCustomer(CustomerRequest request) {
		var customer = customerRepository.save(customerMapper.mapToCustomer(request));
		return customer.getId();
	}

	@Transactional
	public void updateCustomer(String id, CustomerRequest request) {
		var customer = customerRepository.findById(id).orElseThrow();
		
		customer.setFirstName(request.firstName());
		customer.setLastName(request.lastName());
		customer.setEmail(request.email());		
		customer.setAddress(request.address());
		
	}

	
	
}
