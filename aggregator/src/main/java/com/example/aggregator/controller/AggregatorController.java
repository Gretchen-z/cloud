package com.example.aggregator.controller;

import com.example.aggregator.data.Payment;
import com.example.aggregator.data.User;
import com.example.aggregator.data.UserPayment;
import com.example.aggregator.data.dto.ResponseDTO;
import com.example.aggregator.data.dto.UserRequestDTO;
import com.example.aggregator.feignclient.AggregatorFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AggregatorController {

    private final AggregatorFeignClient feignClient;

    @GetMapping("/aggregator/api/payments")
    public ResponseDTO getPayments() {
        List<Payment> payments = feignClient.getPayments();
        List<User> users = feignClient.getUsers(new UserRequestDTO(payments.stream().map(Payment::getSenderId).collect(Collectors.toList())));

        List<UserPayment> resultUserPayments = users.stream().map(u -> {
            List<Payment> userPayments = payments.stream().filter(p -> u.getId() == p.getId()).collect(Collectors.toList());
            return new UserPayment(u, userPayments);
        }).collect(Collectors.toList());

        return new ResponseDTO(resultUserPayments);
    }
}
