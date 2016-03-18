package com.woowahan.riders.spring.practice.board.repository;

import com.woowahan.riders.spring.practice.board.domain.Board;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class BoardRepositoryTest {

    private BoardRepository boardRepository =  new BoardRepository();
    private Logger log = LoggerFactory.getLogger(BoardRepositoryTest.class);

    @Test
    public void save가_정상적으로_되어야_한다() {
        //Given
        Board board = Board.of("test");
        boardRepository.save(board);

        //When
        Board savedBoard = boardRepository.findOne(1L);

        //then
        assertNotNull("정상적으로 저장되어야 한다", savedBoard);
        assertEquals(1L,savedBoard.getId().longValue());
        log.info("savedBoard:{}",board);
    }

    @Test
    public void save후_update가_정상적으로_작동해야_한다() {
        //Given
        Board board = Board.of("게시판1");
        boardRepository.save(board);
    }




}