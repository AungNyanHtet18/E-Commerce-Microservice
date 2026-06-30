package com.dev.anh.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
	   String id,
	   @NotNull(message = "Customer first name must not be empty.")
	   String firstName,
	   String lastName,
	   @NotNull(message = "Customer email must not be empty.")
	   @Email(message = "Customer email is not a valid email address.")
	   String email,
	   Address address) {

}
