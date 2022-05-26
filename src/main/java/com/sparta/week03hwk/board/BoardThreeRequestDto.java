package com.sparta.week03hwk.board;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardThreeRequestDto{
    private String title;
    private String name;
    private LocalDateTime modifyAt;
    private String contents;

    public BoardThreeRequestDto(String title, String name, String contents, LocalDateTime modifiedAt) {
        this.title = title;
        this.name = name;
        this.contents = contents;
        this.modifyAt = modifiedAt;
    }
}
