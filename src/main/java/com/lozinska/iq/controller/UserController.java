package com.lozinska.iq.controller;

import com.lozinska.iq.dto.UserDTO;
import com.lozinska.iq.entity.User;
import com.lozinska.iq.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.lozinska.iq.dto.UserDTO.changeUserToUserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable Integer userID) {
        User user = userService.getUserByID(userID);
        return ResponseEntity.ok(changeUserToUserDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> result = userService.getAllUsers();
        List<UserDTO> resultDTO = new ArrayList<>();
        for (User user : result) {
            resultDTO.add(changeUserToUserDTO(user));
        }
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<List<UserDTO>> getUserByUserName(@PathVariable String userName) {
        List<User> users = userService.getUserByUserName(userName);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(changeUserToUserDTO(user));
        }
        return ResponseEntity.ok(userDTOS);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User newUser = new User();
        newUser.setUserName(userDTO.getUserName());
        newUser.setUserPassword(userDTO.getUserPassword());
        newUser.setUserPhoto(userDTO.getUserPhoto());
//        newUser.setTests(userDTO.getTests());

        User createdUser = userService.createUser(newUser);

        return ResponseEntity.ok(changeUserToUserDTO(createdUser));
    }

    @PatchMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        User newUser = new User();
        newUser.setId(userDTO.getId());
        newUser.setUserName(userDTO.getUserName());
        newUser.setUserPassword(userDTO.getUserPassword());
        newUser.setUserPhoto(userDTO.getUserPhoto());
        newUser.setTests(userDTO.getTests());

        User updatedUser = userService.updateUser(newUser);

        return ResponseEntity.ok(changeUserToUserDTO(updatedUser));
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userID) {
        userService.deleteUser(userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
