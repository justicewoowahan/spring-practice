package com.woowahan.riders.spring.practice.board.repository.support;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class AssignIdFailedException extends RuntimeException {

    public AssignIdFailedException(String msg,Throwable t) {
        super("failed to assign Id", t);
    }
}
