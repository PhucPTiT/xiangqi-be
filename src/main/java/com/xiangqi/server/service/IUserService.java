package com.xiangqi.server.service;

import com.xiangqi.server.dto.UserDTO;

import java.util.List;

public interface IUserService {
    public List<UserDTO> getAllUser();
    public void deleteUser(Long id);

    public void createUser(UserDTO userDTO);
    public void updateUser(Long id, UserDTO userDTO);

    public UserDTO login(UserDTO userDTO);
}
