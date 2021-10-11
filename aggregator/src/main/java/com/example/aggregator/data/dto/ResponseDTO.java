package com.example.aggregator.data.dto;

import com.example.aggregator.data.UserPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO {
  private List<UserPayment> userPayments;
}
