package com.example.user.controller;

import com.example.user.data.User;
import com.example.user.data.UserRequestDTO;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/api/users")
    public List<User> getAll(@RequestParam UserRequestDTO userRequestDTO){
        return userService.getAll(userRequestDTO.getUsersId().stream().mapToLong(i->i).toArray());
    }
}
