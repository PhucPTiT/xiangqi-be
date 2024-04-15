package com.xiangqi.server.service.impl;

import com.xiangqi.server.converter.UserConverter;
import com.xiangqi.server.dto.UserDTO;
import com.xiangqi.server.entity.User;
import com.xiangqi.server.repository.UserRepository;
import com.xiangqi.server.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;
    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            userDTOList.add(userConverter.toDTO(user));
        }
        return userDTOList;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = userConverter.toEntity(userDTO);
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).get();
        user = userConverter.toEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user == null) {
            return null;
        }
        if (BCrypt.checkpw(userDTO.getPassword(), user.getPassword())) {
            return userConverter.toDTO(user);
        }
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return userConverter.toDTO(user);
    }
}
