package com.example.springboot.mapper;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void save(User user);
    User findById(String userId);
    void update(User user);
    void delete(String userId);
}