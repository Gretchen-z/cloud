package com.example.user.repository;


import com.example.user.data.User;
import com.example.user.jdbc.JdbcTemplate;
import com.example.user.jdbc.RowMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userRowMapper = resultSet -> new User(
            resultSet.getLong("id"),
            resultSet.getString("name")
    );

    public User findById(long id) {
        // language=PostgreSQL
        String query = "SELECT * FROM users WHERE id = ? ;" ;

        return jdbcTemplate.queryOne(query, userRowMapper, id);
    }
}

