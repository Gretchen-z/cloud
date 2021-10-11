package com.example.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserApplication {
  private final Log logger = LogFactory.getLog(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }
}
