package com.dev.anh.customer.customer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String msg;
}
