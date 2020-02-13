package com.lozinska.iq.service.impl;

import com.lozinska.iq.entity.User;
import com.lozinska.iq.repository.UserRepository;
import com.lozinska.iq.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public User getUserByID(Integer userId){
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User updatedUser){
        User user = getUserByID(updatedUser.getId());
        user.setUserPhoto(updatedUser.getUserPhoto());
        user.setPassword(updatedUser.getPassword());
        user.setUsername(updatedUser.getUsername());
        user.setTests(updatedUser.getTests());
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(Integer userID){
        userRepository.deleteById(userID);
    }
}
