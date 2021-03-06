package com.example.producer.service;

import com.example.producer.data.Payment;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final KafkaTemplate<String, Payment> template;

    public void send(Payment payment) {

        //TODO validation


        template.send(new ProducerRecord<>("payments", "ibank", payment));
    }

//  public void send() {
//    final ListenableFuture<SendResult<String, Payment>> future = template.send(
//        new ProducerRecord<>("payments", "ibank", new Payment(
//            System.currentTimeMillis(),
//            1,
//            100_00,
//            "Пополнение"
//        )));
//
//    ////
//    future.addCallback(new ListenableFutureCallback<>() {
//      @Override
//      public void onFailure(@NonNull Throwable e) {
//        e.printStackTrace();
//      }
//
//      @Override
//      public void onSuccess(SendResult<String, Payment> result) {
//        logger.info(result);
//      }
//    });
//  }
}
