package com.example.user.service;

import com.example.user.data.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final UserRepository userRepository;

    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    public List<User> getAll(long ... ids) {
        List<User> result = new ArrayList<>();

        for (long id : ids) {
            result.add(findUserById(id));
        }

        return result;
    }
}
