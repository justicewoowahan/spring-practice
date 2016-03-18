package com.woowahan.riders.spring.practice.board.repository.support;

import com.woowahan.riders.spring.practice.board.repository.support.sequence.AutoincrementSequenceGenerator;
import com.woowahan.riders.spring.practice.board.repository.support.sequence.SequenceGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class IdClassTypeSequenceGeneratorResolverTest {

    private SequenceGeneratorResolver<Class<?>> generatorResolver = new IdClassTypeSequenceGeneratorResolver();

    @Test
    public void idClass타입이_Long형일_경우_AutoincrementSequenceGenerator가_반환되어야_한다() {
        SequenceGenerator resolve = generatorResolver.resolve(Long.class);
        assertNotNull(resolve);
        assertTrue(resolve instanceof AutoincrementSequenceGenerator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void idClass타입이_Long형이_아닐때에는_예외가_발생해야한다() {
        SequenceGenerator resolve = generatorResolver.resolve(Integer.class);
    }
}