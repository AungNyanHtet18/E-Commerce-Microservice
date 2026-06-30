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

}
