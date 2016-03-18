package com.woowahan.riders.spring.practice.board.repository.support;

import com.woowahan.riders.spring.practice.board.repository.support.sequence.AutoincrementSequenceGenerator;
import com.woowahan.riders.spring.practice.board.repository.support.sequence.SequenceGenerator;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class IdClassTypeSequenceGeneratorResolver implements SequenceGeneratorResolver<Class<?>> {

    @Override
    public SequenceGenerator resolve(Class<?> generatorType) {
        if (generatorType.isAssignableFrom(Long.class)) {
            return new AutoincrementSequenceGenerator();
        }
        throw new IllegalArgumentException(String.format("sequence generator for [classtype:%s] does not exists!", generatorType.getName()));
    }
}
