package com.dev.anh.customer.customer;

public record CustomerResponse(
	String id,
	String firstName,
	String lastName,
	String email,
	Address address) {

}
