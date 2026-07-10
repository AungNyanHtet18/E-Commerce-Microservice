package com.dev.anh.order.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.dev.anh.order.customer.CustomerResponse;
import com.dev.anh.order.order.PaymentMethod;
import com.dev.anh.order.product.PurchaseResponse;

public record OrderComfirmation (
   String orderReference,
   BigDecimal totalAmount,
   PaymentMethod paymentMethod,
   CustomerResponse customer,
   List<PurchaseResponse> products) {

}
