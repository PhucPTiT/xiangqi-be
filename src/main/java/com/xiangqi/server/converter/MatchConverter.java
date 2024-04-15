package com.xiangqi.server.converter;

import com.xiangqi.server.dto.MatchDTO;
import com.xiangqi.server.entity.Match;
import com.xiangqi.server.entity.Modal;
import com.xiangqi.server.entity.User;
import com.xiangqi.server.repository.ModalRepository;
import com.xiangqi.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.util.Optional;

@Component
public class MatchConverter {
    @Autowired
    private UserConverter userConverter;

    @Autowired
    private ModalConverter modalConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModalRepository modalRepository;

    @Autowired
    private static final String LOCAL_TIMEZONE = "Asia/Ho_Chi_Minh";
    public MatchDTO toDTO(Match match) {
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(match.getId());
        matchDTO.setTime(match.getTime().toString());
        matchDTO.setResult(match.getResult());
        matchDTO.setUser(userConverter.toDTO(match.getUser()));
        matchDTO.setModal(modalConverter.toDTO(match.getModal()));
        return matchDTO;
    }

    public Match toEntity(MatchDTO matchDTO) {
        Match match = new Match();
        match.setId(matchDTO.getId());
        match.setTime(getCurrentTimeInLocalZone());
        match.setResult(matchDTO.getResult());

        Optional<User> user = userRepository.findById(matchDTO.getUserId());
        Optional<Modal> modal = modalRepository.findById(matchDTO.getModalId());

        match.setUser(user.orElse(null));
        match.setModal(modal.orElse(null));
        return match;
    }

    private LocalDateTime getCurrentTimeInLocalZone() {
        ZoneId localZone = ZoneId.of(LOCAL_TIMEZONE);
        ZonedDateTime localTime = ZonedDateTime.now(localZone);
        return localTime.toLocalDateTime();
    }
}
