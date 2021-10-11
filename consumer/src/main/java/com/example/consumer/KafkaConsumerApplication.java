package com.example.consumer;

import com.example.consumer.data.Payment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@SpringBootApplication
public class KafkaConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerApplication.class, args);
  }

  @Bean
  public NewTopic messagesTopic() {
    return new NewTopic("paymentsProcess", 3, (short)1);
  }
}
