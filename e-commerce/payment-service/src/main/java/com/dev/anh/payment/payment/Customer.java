package com.dev.anh.payment.payment;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(
	String id,
	@NotNull(message = "Firstname is required")
	String firstName,
	@NotNull(message = "Lastname is required")
	String lastName,
	@Email(message = "Customer Email is invalid")
	String email) {
}
