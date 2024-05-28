package com.ecommerce.paymentservice.Controllers;

import com.ecommerce.paymentservice.Service.PaymentService;
import com.ecommerce.paymentservice.dto.InitiatePaymentRequestDto;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentService razorpayPaymentService;
    PaymentService stripePaymentService;
    public PaymentController(@Qualifier("razorpay") PaymentService razorpayPaymentService,
                             @Qualifier("stripe") PaymentService stripePaymentService) {
        this.razorpayPaymentService = razorpayPaymentService;
        this.stripePaymentService = stripePaymentService;
    }

    @PostMapping("/initiate")
    public String initiatePayment(@RequestBody
                                      InitiatePaymentRequestDto
                                              initiatePaymentRequestDto) throws RazorpayException {
        getPaymentService().doPayment(initiatePaymentRequestDto.getOrderId(),
                initiatePaymentRequestDto.getAmount(),
                initiatePaymentRequestDto.getEmail(),
                initiatePaymentRequestDto.getPaymentId(),
                initiatePaymentRequestDto.getCustomerId(),
                initiatePaymentRequestDto.getPhoneNumber());

        return "Success";
    }

    private PaymentService getPaymentService() {
        if(Math.random()>0.4){
            return razorpayPaymentService;
        }
        else{
            return stripePaymentService;
        }
    }

}
