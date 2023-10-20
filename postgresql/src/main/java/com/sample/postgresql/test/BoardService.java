package com.sample.postgresql.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : JB
 * @packageName : com.sample.postgresql.test
 * @fileName : BoardService
 * @description :
 * @since : 2023-10-18
 */
@Service
public class BoardService {

    @Autowired private BoardRepository boardRepository;

    public void insert(BoardEntity param) {
        boardRepository.save(param);
    }

    public List<BoardEntity> load() {
        return boardRepository.findAll();
    }
}
