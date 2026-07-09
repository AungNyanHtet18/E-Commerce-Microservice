package com.dev.anh.order.order;

import java.math.BigDecimal;
import java.util.List;

import com.dev.anh.order.product.PurchaseRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
	Integer id,
	String reference,
	@Positive(message = "Order amount should be positive.")
	BigDecimal amount,
	@NotNull(message = "Payment method shouldn't be empty.")
	PaymentMethod paymentMethod,
	@NotNull(message = "Customer Id should be present.")
	@NotBlank(message = "Customer Id should be present.")
	String customerId,
	@NotEmpty(message = "You must purchase at least one product.")
	List<PurchaseRequest> products ) {

}
