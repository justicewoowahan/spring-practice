package com.woowahan.riders.spring.practice.board.repository.support;

import com.woowahan.riders.spring.practice.board.repository.support.sequence.SequenceGenerator;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public interface SequenceGeneratorResolver<T> {
    SequenceGenerator resolve(T generatorType);
}
