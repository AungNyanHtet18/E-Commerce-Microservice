package com.dev.anh.customer.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

	public Customer mapToCustomer(CustomerRequest request) {
		
		if(request == null) {
			 return null;
		}
		
		var customer =  Customer.builder()
			           .id(request.id())
			           .firstName(request.firstName())
			           .lastName(request.lastName())
			           .email(request.email())
			           .address(request.address())
			           .build();
		return customer;
	}

	public static CustomerResponse mapToCustomerResponse(Customer customer) {
		return new CustomerResponse(
				     customer.getId(), 
				     customer.getFirstName(),
				     customer.getLastName(),
				     customer.getEmail(),
				     customer.getAddress());
	}
}
