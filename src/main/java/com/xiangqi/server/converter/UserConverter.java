package com.xiangqi.server.converter;

import com.xiangqi.server.dto.MatchDTO;
import com.xiangqi.server.dto.UserDTO;
import com.xiangqi.server.entity.Match;
import com.xiangqi.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    @Autowired
    private MatchConverter matchConverter;

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

        List<MatchDTO> matches = new ArrayList<>();
        List<Match> matchList = user.getMatches();
        for(Match match : matchList) {
            MatchDTO matchDTO = new MatchDTO();
            matchDTO = matchConverter.toDTO(match);
            matches.add(matchDTO);
        }
        userDTO.setMatches(matches);
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
