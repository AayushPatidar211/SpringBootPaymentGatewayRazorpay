package org.example.springpaymentgatewayrazorpay.controller;

import com.razorpay.RazorpayException;
import org.example.springpaymentgatewayrazorpay.service.RazorpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private RazorpayService razorpayService;

    @PostMapping("create-order")
    public String createOrder(@RequestParam int amount, @RequestParam String currency) {

       try {
           return razorpayService.createOrder(amount, currency, "recepeint_100");
       } catch (RuntimeException e){
           throw new RuntimeException(e);
       } catch (RazorpayException e) {
           throw new RuntimeException(e);
       }
    }
}
