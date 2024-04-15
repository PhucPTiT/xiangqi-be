package com.xiangqi.server.service.Impl;

import com.xiangqi.server.converter.MatchConverter;
import com.xiangqi.server.dto.MatchDTO;
import com.xiangqi.server.entity.Matches;
import com.xiangqi.server.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchConverter matchConverter;
    public ResponseEntity<MatchDTO> createMatch(MatchDTO matchDTO) {
        Matches match = matchConverter.toEntity(matchDTO);
        matchRepository.save(match);
        MatchDTO createdMatchDTO = matchConverter.toDTO(match);
        return ResponseEntity.ok(createdMatchDTO);
    }
}
