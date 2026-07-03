package com.dev.anh.product.product;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
	@NotNull(message = "Product Id is required.")
	Integer productId,
	@NotNull(message = "Product quantity is required.")
	double quantity) {

	
}
