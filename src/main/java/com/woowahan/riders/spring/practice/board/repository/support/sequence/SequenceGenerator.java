package com.woowahan.riders.spring.practice.board.repository.support.sequence;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public interface SequenceGenerator<T> {
    T generate();
}
