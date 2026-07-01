package com.dev.anh.customer.customer;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.dev.anh.customer.customer.exception.CustomerNotFoundException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	public List<CustomerResponse> findAll() {
		return  customerRepository.findAll().stream()
	             .map(CustomerMapper::mapToCustomerResponse)
	             .collect(Collectors.toList());
	}
	
	public Boolean existsById(String customerId) {
		return customerRepository.findById(customerId)
				    .isPresent();
	}
	
	public CustomerResponse findById(String customerId) {
		return customerRepository.findById(customerId)
				 .map(CustomerMapper::mapToCustomerResponse)
				 .orElseThrow(() -> new CustomerNotFoundException(
					String.format("Customer is not found with the provided ID :: %s", customerId)));
	}
	
	public String createCustomer(CustomerRequest request) {
		return customerRepository.save(customerMapper
			    .mapToCustomer(request))
			    .getId();
	}

	public void updateCustomer(String customerId, CustomerRequest request) {
		var customer = customerRepository.findById(customerId)
				        .orElseThrow(() -> new CustomerNotFoundException(
				        String.format("Customer is not found with the provided ID :: %s", customerId)));

		updateCustomer(customer, request);
		customerRepository.save(customer);
	}

	private void updateCustomer(Customer customer, CustomerRequest request) {

		if(StringUtils.isNotBlank(request.firstName())) {
			 customer.setFirstName(request.firstName());
		}
		
		if(StringUtils.isNotBlank(request.lastName())) {
			 customer.setLastName(request.lastName());
		}
		
		if(StringUtils.isNotBlank(request.email())) {
			 customer.setEmail(request.email());
		}
		
		if(request.address() != null) {
			 customer.setAddress(request.address());	 
		}
	}

	public void deleteCustomerById(String customerId) {
		
		var customer = customerRepository.findById(customerId)
				         .orElseThrow(() -> new CustomerNotFoundException(
						 String.format("Customer is not found with the provided ID :: %s", customerId)));
		
		customerRepository.deleteById(customer.getId());
	}
}
