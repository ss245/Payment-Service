package com.ecommerce.paymentservice.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RazorpayConfig {
    @Value(value = "${razorpay.key.id}")
    private String razorpayKeyId;
    @Value(value = "${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyId,razorpayKeySecret);
    }
}
