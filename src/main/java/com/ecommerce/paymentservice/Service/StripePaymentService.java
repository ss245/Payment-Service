package com.ecommerce.paymentservice.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentService implements PaymentService {

    private RazorpayClient razorpayClient;
    public StripePaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public void doPayment(Long orderId, Double amount, String email, Long paymentId, Long customerId, String phoneNumber) throws RazorpayException {

    }
}
