package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    void addUser(User user);

    void deleteUserById(int id);

    List<User> getAllUser();

    User getUserById(int id);

    void updateUser(User user);
}
