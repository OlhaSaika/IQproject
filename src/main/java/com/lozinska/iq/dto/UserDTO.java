package com.lozinska.iq.dto;

import com.lozinska.iq.entity.Role;
import com.lozinska.iq.entity.Test;
import com.lozinska.iq.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private Integer id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String username;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;
    private String userPhoto;
    @NotNull
    @NotEmpty
    @NotBlank
    private String email;

    private Set<Role> roles;

    private List<Test> tests;


    public static UserDTO changeUserToUserDTO(User user) {
        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setId(user.getId());
        newUserDTO.setUsername(user.getUsername());
        newUserDTO.setPassword(user.getPassword());
        newUserDTO.setUserPhoto(user.getUserPhoto());
        newUserDTO.setEmail(user.getEmail());
        newUserDTO.setRoles(user.getRoles());
        newUserDTO.setTests(user.getTests());

        return newUserDTO;
    }
}
