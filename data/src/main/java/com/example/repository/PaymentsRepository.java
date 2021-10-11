package com.example.repository;

import com.example.data.Payment;
import com.example.jdbc.JdbcTemplate;
import com.example.jdbc.RowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PaymentsRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Payment> paymentRowMapper = resultSet -> new Payment(
            resultSet.getLong("id"),
            resultSet.getLong("senderId"),
            resultSet.getString("cardNumber"),
            resultSet.getInt("amount"),
            resultSet.getString("comment")
    );

    public void savePayment(Payment payment) {
        // language=PostgreSQL
        String query = "INSERT INTO payments(\"cardNumber\", \"senderId\",  amount,  comment) VALUES (?, ?, ?, ?);";
        jdbcTemplate.queryOne(query, paymentRowMapper, payment.getCardNumber(), payment.getSenderId(), payment.getAmount(), payment.getComment());
    }

    public List<Payment> findAll(int amount) {
        // language=PostgreSQL
        String query = "SELECT * FROM payments limit ?;";

        return jdbcTemplate.queryAll(query, paymentRowMapper, amount);
    }
}
