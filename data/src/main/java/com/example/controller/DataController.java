package com.example.controller;

import com.example.data.Payment;
import com.example.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    @GetMapping("/data/api/payments")
    public List<Payment> getAll(){
        return dataService.getAll();
    }
}
