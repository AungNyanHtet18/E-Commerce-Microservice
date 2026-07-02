package com.dev.anh.product.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
		Integer id,
		@NotNull(message = "Product name is required.")
		String name,
		@NotNull(message = "Product description is required.")
		String description,
		@Positive(message = "Product quantity must be positive.")
		double availableQuantity,
		@Positive(message = "Product price is required. ")
		BigDecimal price,
		@NotNull(message = "Product category is required.")
		Integer categoryId) {
}
