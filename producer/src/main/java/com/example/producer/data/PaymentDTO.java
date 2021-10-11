package com.example.producer.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private long senderId;
    private String cardNumber;
    private long amount;
    private String comment;
}
