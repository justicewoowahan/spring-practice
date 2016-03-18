package com.woowahan.riders.spring.practice.board.repository.sequence;

import com.woowahan.riders.spring.practice.board.repository.support.sequence.AutoincrementSequenceGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class AutoincrementSequenceGeneratorTest {

    private AutoincrementSequenceGenerator sequenceGenerator = new AutoincrementSequenceGenerator();

    @Test
    public void 시퀀스생성기가_호출될_때_마다_증가해야_한다() {
        Long sequence = sequenceGenerator.generate();
        assertEquals("첫번째 호출이므로 1로 증가해야 한다", 1L, sequence.longValue());
        sequence = sequenceGenerator.generate();
        assertEquals("첫번째 호출이므로 2로 증가해야 한다", 2L, sequence.longValue());
        sequence = sequenceGenerator.generate();
        assertEquals("첫번째 호출이므로 3로 증가해야 한다", 3L, sequence.longValue());
    }

}