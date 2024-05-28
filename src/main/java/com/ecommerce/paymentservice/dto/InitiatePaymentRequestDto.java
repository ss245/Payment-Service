package com.ecommerce.paymentservice.dto;

import lombok.Data;

@Data
public class InitiatePaymentRequestDto {
    private Long paymentId;
    private Long customerId;
    private Double amount;
    private String phoneNumber;
    private String email;
    private Long orderId;
}
