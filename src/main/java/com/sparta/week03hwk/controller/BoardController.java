package com.sparta.week03hwk.controller;


import com.sparta.week03hwk.board.*;
import com.sparta.week03hwk.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    public final BoardRepository boardRepository;
    public final BoardService boardService;


    // 게시글 작성 API
    @PostMapping ("/api/boards")
    public Board createBoard (@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }
    // 게시글 조회 API
    @GetMapping ("/api/boards/detail")
    public List<BoardThreeRequestDto> readThreeBoard () { return boardService.three();
    }
    // 전체 게시글 목록 조회 API
    @GetMapping ("/api/boards")
    public List<BoardTwoRequestDto> readTwoBoard () { return boardService.two();
    }
    // 게시글 수정 API
    @PutMapping ("/api/boards/{id}")
    public String updateBoard (@PathVariable Long id,@RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }
    // 게시글 삭제 API
    @DeleteMapping ("/api/boards/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestParam int password) {
        return boardService.delete(id, password);
    }
}
