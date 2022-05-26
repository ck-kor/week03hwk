package com.sparta.week03hwk.service;


import com.sparta.week03hwk.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    public final BoardRepository boardRepository;
    //게시글 수정
    @Transactional
    public String update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디를 찾지 못했습니다")
        );
        if (board.getPassword() == requestDto.getPassword()) {
            board.update(requestDto);
            return "성공";
        } else {
            return "실패";
        }
    }
    // 게시글 삭제
    @Transactional
    public String delete(Long id, int password) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디를 찾지 못했습니다")
        );
        if (board.getPassword() == password) {
            boardRepository.deleteById(id);
            return "성공";
        } else {
            return "실패";
        }
    }
    // 전체 게시글 목록 조회
    public List<BoardTwoRequestDto> two() {
        List<Board> boardlist = boardRepository.findAllByOrderByCreatedAtDesc();
        List<BoardTwoRequestDto> twolist = new ArrayList<>();
        for (int i = 0; i < boardlist.size(); i++) {
            Board board = boardlist.get(i);
            BoardTwoRequestDto two = new BoardTwoRequestDto(board.getTitle(), board.getName(),board.getCreatedAt());
            twolist.add(two);
        }
        return twolist;
    }
    // 게시글 조회
    public List<BoardThreeRequestDto> three() {
        List<Board> boardlist = boardRepository.findAll();
        List<BoardThreeRequestDto> threelist = new ArrayList<>();
        for (int i = 0; i < boardlist.size(); i++) {
            Board board = boardlist.get(i);
            BoardThreeRequestDto three = new BoardThreeRequestDto(board.getTitle(), board.getName(), board.getContents(), board.getModifiedAt());
            threelist.add(three);
        }
        return threelist;
    }
}