package com.example.service;

import com.example.data.Payment;
import com.example.repository.PaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DataService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final PaymentsRepository paymentsRepository;

    @KafkaListener(topics = "paymentsProcess")
    public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
        logger.info(message);
        paymentsRepository.savePayment(message);
        acknowledgment.acknowledge();
    }

    public List<Payment> getAll() {
        return paymentsRepository.findAll(100);
    }
}
