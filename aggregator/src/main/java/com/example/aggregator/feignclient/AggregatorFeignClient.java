package com.example.aggregator.feignclient;

import com.example.aggregator.data.Payment;
import com.example.aggregator.data.User;
import com.example.aggregator.data.dto.UserRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:8080")
public interface AggregatorFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/data/api/payments")
    List<Payment> getPayments();

    @RequestMapping(method = RequestMethod.POST, value = "/user/api/users", consumes = "application/json")
    List<User> getUsers(UserRequestDTO userRequestDTO);
}
