package com.sparta.week03hwk.board;


import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String name;
    private String contents;
    private int password;
}
