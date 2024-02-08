package com.devesh.userinfo.controller;

import com.devesh.userinfo.dto.UserDTO;
import com.devesh.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        var userdto = userService.addUser(userDTO);
        return new ResponseEntity<>(userdto, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("fetchUserById/{id}")
    public ResponseEntity<UserDTO> fetchUserDetailsByID(@PathVariable int id){
        return userService.fetchUserDetailsByID(id);
    }

}
