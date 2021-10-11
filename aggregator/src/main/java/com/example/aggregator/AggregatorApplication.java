package com.example.aggregator;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.data.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequiredArgsConstructor
@CommonsLog
public class AggregatorApplication {
  private final DiscoveryClient discoveryClient;
  private final DataClient dataClient;

  @GetMapping("/value")
  public ResponseDTO value() {
    return dataClient.getValue();
  }

  public static void main(String[] args) {
    SpringApplication.run(AggregatorApplication.class, args);
  }
}
