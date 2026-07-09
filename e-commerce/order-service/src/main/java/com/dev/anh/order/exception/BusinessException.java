package com.dev.anh.order.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
    private final String msg;
}
