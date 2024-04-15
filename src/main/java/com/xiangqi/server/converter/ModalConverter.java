package com.xiangqi.server.converter;

import com.xiangqi.server.dto.ModalDTO;
import com.xiangqi.server.entity.Modal;
import org.springframework.stereotype.Component;


@Component
public class ModalConverter {

    public ModalDTO toDTO(Modal modal) {
        ModalDTO modalDTO = new ModalDTO();
        modalDTO.setId(modal.getId());
        modalDTO.setName(modal.getName());
        modalDTO.setFilePath(modal.getFilePath());
        modalDTO.setDepth(modal.getDepth());
        modalDTO.setAction(modal.getAction());

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
