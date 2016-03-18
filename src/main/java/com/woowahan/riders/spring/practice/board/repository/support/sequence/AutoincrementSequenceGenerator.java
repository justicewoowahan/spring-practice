package com.woowahan.riders.spring.practice.board.repository.support.sequence;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class AutoincrementSequenceGenerator implements SequenceGenerator<Long> {

    private AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Long generate() {
        return sequence.incrementAndGet();
    }
}
