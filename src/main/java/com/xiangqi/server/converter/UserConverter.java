package com.xiangqi.server.converter;

import com.xiangqi.server.dto.UserDTO;
import com.xiangqi.server.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setNickName(user.getNickName());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setNickName(userDTO.getNickName());
        user.setAddress(userDTO.getAddress());
        return user;
    }
}
