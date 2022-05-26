package com.sparta.week03hwk.board;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardTwoRequestDto {
    private String title;
    private String name;
    private LocalDateTime createdAt;

    public BoardTwoRequestDto(String title, String name, LocalDateTime createdAt) {
        this.title = title;
        this.name = name;
        this.createdAt = createdAt;
    }
}
