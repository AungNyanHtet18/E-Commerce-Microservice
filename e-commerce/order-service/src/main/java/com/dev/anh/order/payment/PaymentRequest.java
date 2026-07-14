package com.dev.anh.order.payment;

import java.math.BigDecimal;

import com.dev.anh.order.customer.CustomerResponse;
import com.dev.anh.order.order.PaymentMethod;

public record PaymentRequest(
    Integer orderId,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String orderReference,
    CustomerResponse customer) {
}