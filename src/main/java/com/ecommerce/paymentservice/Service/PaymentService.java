package com.ecommerce.paymentservice.Service;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

public interface PaymentService {
    void doPayment(Long orderId, Double amount, String email, Long paymentId, Long customerId, String phoneNumber ) throws RazorpayException;
}
