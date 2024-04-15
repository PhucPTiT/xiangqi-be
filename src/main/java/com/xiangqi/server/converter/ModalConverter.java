package com.xiangqi.server.converter;

import com.xiangqi.server.dto.MatchDTO;
import com.xiangqi.server.dto.ModalDTO;
import com.xiangqi.server.entity.Match;
import com.xiangqi.server.entity.Modal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModalConverter {
    @Autowired
    private MatchConverter matchConverter;

    public ModalDTO toDTO(Modal modal) {
        ModalDTO modalDTO = new ModalDTO();
        modalDTO.setId(modal.getId());
        modalDTO.setName(modal.getName());
        modalDTO.setFilePath(modal.getFilePath());
        modalDTO.setDepth(modal.getDepth());
        modalDTO.setAction(modal.getAction());

        List<MatchDTO> matchDTOs = new ArrayList<>();
        List<Match> matchs = modal.getMatches();
        for(Match match : matchs) {
            MatchDTO matchDTO = new MatchDTO();
            matchDTO = matchConverter.toDTO(match);
            matchDTOs.add(matchDTO);
        }
        modalDTO.setMatches(matchDTOs);
        return modalDTO;
    }

    public Modal toEntity(ModalDTO modalDTO) {
        Modal modal = new Modal();
        modal.setId(modalDTO.getId());
        modal.setName(modalDTO.getName());
        modal.setFilePath(modalDTO.getFilePath());
        modal.setDepth(modalDTO.getDepth());
        modal.setAction(modalDTO.getAction());
        return modal;
    }
}
