package com.example.aggregator.client;

import com.example.aggregator.data.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "data")
public interface DataClient {
  @GetMapping
  ResponseDTO getValue();
}
