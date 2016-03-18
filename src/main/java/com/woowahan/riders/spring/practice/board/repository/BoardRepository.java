package com.woowahan.riders.spring.practice.board.repository;

import com.woowahan.riders.spring.practice.board.domain.Board;
import com.woowahan.riders.spring.practice.board.repository.support.SimpleJpaRepository;
import com.woowahan.riders.spring.practice.board.repository.support.sequence.AutoincrementSequenceGenerator;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class BoardRepository extends SimpleJpaRepository<Board,Long>  {

    public BoardRepository() {
        setSequenceGenerator(new AutoincrementSequenceGenerator());
    }

}
