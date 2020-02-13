package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Test;
import com.lozinska.iq.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String userName;

    private String userPassword;

    private String userPhoto;

    private List<Test> tests;

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
