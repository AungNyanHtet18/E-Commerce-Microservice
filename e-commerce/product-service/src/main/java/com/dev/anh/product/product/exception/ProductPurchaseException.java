package com.dev.anh.product.product.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductPurchaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String msg;
}
