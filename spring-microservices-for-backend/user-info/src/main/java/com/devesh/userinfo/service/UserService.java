package com.devesh.userinfo.service;

import com.devesh.userinfo.dto.UserDTO;
import com.devesh.userinfo.entity.User;
import com.devesh.userinfo.mapper.UserMapper;
import com.devesh.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final UserMapper mapperInstance = UserMapper.INSTANCE;

    public ResponseEntity<UserDTO> fetchUserDetailsByID(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser
                .map(user -> new ResponseEntity<>(mapperInstance.mapUsertoUserDTO(user), HttpStatus.OK))
                .orElseGet(()->new ResponseEntity(null, HttpStatus.NOT_FOUND));
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(mapperInstance::mapUsertoUserDTO)
                .toList();
    }

    public UserDTO addUser(UserDTO userDTO){
        return mapperInstance.mapUsertoUserDTO
                (userRepository.save(mapperInstance.mapUserDTOtoUser(userDTO)));
    }

}
