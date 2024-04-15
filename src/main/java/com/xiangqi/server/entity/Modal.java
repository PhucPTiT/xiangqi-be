package com.xiangqi.server.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Modal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String filePath;
    private Long depth;
    private Long action;

    @OneToMany(mappedBy = "modal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> matches;

}
