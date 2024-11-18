package com.example.springboot.service;

import com.example.springboot.domain.User;
import com.example.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user.setUserAuth("USER");

        userMapper.save(user);
    }

    public User getUserById(String userId) {
        return userMapper.findById(userId);
    }

    public void updateUser(User user) {
        userMapper.update(user);
    }

    public void deleteUser(String userId) {
        userMapper.delete(userId);
    }
}
