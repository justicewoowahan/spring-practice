package com.woowahan.riders.spring.practice.board.repository;

import com.woowahan.riders.spring.practice.board.domain.Board;
import com.woowahan.riders.spring.practice.board.repository.support.SimpleJpaRepository;
import com.woowahan.riders.spring.practice.board.repository.support.sequence.AutoincrementSequenceGenerator;
import com.woowahan.riders.spring.practice.board.repository.support.sequence.SequenceGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class SimpleJpaRepositoryTest {

    private SequenceGenerator<Long> autoincrementSequenceGenerator;
    private SimpleJpaRepository<Board, Long> simpleJpaRepository;

    @Before
    public void setup() {
        autoincrementSequenceGenerator = new AutoincrementSequenceGenerator();
        simpleJpaRepository = new SimpleJpaRepository();
        simpleJpaRepository.setSequenceGenerator(autoincrementSequenceGenerator);
    }


    @Test
    public void save_호출시_정상적으로_데이터가_저장되어야_한다() {
        //Given
        String boardName = "게시판1";
        Board board = Board.of(boardName);

        //When
        simpleJpaRepository.save(board);

        //then
        Board savedBoard = simpleJpaRepository.findOne(1L);
        assertNotNull("저장된 게시판 정보가 존재해야 한다", savedBoard);
        assertEquals("저장된 게시판명은 '게시판1'이어야 한다",boardName, savedBoard.getName());
    }

    @Test
    public void findOne호출시_저장된_객체가_정상적으로_반환되어야_한다() {
        //Given
        String boardName = "저장된게시판1";
        Board board = Board.of(boardName);
        simpleJpaRepository.save(board);

        //when
        Board savedBoard = simpleJpaRepository.findOne(1L);
        assertNotNull("저장된 게시판 정보가 존재해야 한다", savedBoard);
        assertEquals("저장된 게시판명은 '저장된게시판1'이어야 한다",boardName, savedBoard.getName());
    }

    @Test
    public void findAll호출시_저장된_모든_객체의_리스트가_반환되어야_한다() {
        int savedCnt = 10;
        for (int i = 0; i < savedCnt; i++) {
            Board board = Board.of("게시판" + i);
            simpleJpaRepository.save(board);
        }

        List<Board> all = simpleJpaRepository.findAll();

        assertNotNull(all);
        assertEquals("저장된 게시판의 총 갯수는 10개여야 한다", savedCnt, all.size());
    }
}