package com.lozinska.iq.service;

import com.lozinska.iq.entity.User;

import java.util.List;


public interface UserService {

    User getUserByID(Integer userId);

    List<User> getAllUsers();

    List<User> getUserByUserName(String userName);

    User createUser (User user);

    User updateUser(User user);

    void deleteUser(Integer userID);
}
