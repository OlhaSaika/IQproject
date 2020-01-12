package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Test;
import com.lozinska.iq.entity.User;

import java.util.List;

public class UserDTO {

    private Integer id;

    private String userName;

    private String userPassword;

    private String userPhoto;

    private List<Test> tests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public static UserDTO changeUserToUserDTO (User user){
        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setId(user.getId());
        newUserDTO.setUserName(user.getUserName());
        newUserDTO.setUserPassword(user.getUserPassword());
        newUserDTO.setUserPhoto(user.getUserPhoto());
        newUserDTO.setTests(user.getTests());
        return newUserDTO;
    }
}
