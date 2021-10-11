package com.example.producer.controller;

import com.example.producer.data.Payment;
import com.example.producer.data.PaymentDTO;
import com.example.producer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/producer/api/payments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment result = new Payment();
        result.setSenderId(paymentDTO.getSenderId());
        result.setCardNumber(paymentDTO.getCardNumber());
        result.setAmount(paymentDTO.getAmount());
        result.setComment(paymentDTO.getComment());
        paymentService.send(result);
    }
}
