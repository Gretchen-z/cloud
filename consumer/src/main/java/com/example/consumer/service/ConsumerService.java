package com.example.consumer.service;

import com.example.consumer.data.Payment;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsumerService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final KafkaTemplate<String, Payment> template;

    @KafkaListener(groupId = "consumer", topics = "payments")
    public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
        logger.info(message);
        template.send(new ProducerRecord<>("paymentsProcess", message));
        acknowledgment.acknowledge();
    }
}
