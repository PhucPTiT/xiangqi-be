package com.xiangqi.server.dto;

import lombok.Data;

import java.util.List;

@Data
public class ModalDTO {
    private Long id;
    private String name;
    private String filePath;
    private Long depth;
    private Long action;

    private List<MatchDTO> matches;

}
