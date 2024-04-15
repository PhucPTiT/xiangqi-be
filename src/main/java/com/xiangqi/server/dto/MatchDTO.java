package com.xiangqi.server.dto;

import lombok.Data;

@Data
public class MatchDTO {
    private Long id;
    private String time;
    private String result;

    private UserDTO user;
    private ModalDTO modal;

    private Long userId;
    private Long modalId;
}
