package com.devesh.userinfo.mapper;

import com.devesh.userinfo.dto.UserDTO;
import com.devesh.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapUserDTOtoUser(UserDTO userDTO);
    UserDTO mapUsertoUserDTO(User user);

}
