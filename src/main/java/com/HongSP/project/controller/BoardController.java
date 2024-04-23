package com.HongSP.project.controller;

import com.HongSP.project.domain.Board;
import com.HongSP.project.repository.BoardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BoardController {
    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping()
    public String personSave() {
        return "index";
    }
}
