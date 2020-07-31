package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    public List<User> getAllUser() {
        return mapper.getAllUser();
    }

    public String addUser(User user) {
        mapper.addUser(user);
        return "addUser";
    }

    public String deleteUser(int id) {
        mapper.deleteUserById(id);
        return "success";
    }


}
