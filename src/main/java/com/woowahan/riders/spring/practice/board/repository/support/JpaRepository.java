package com.woowahan.riders.spring.practice.board.repository.support;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by justicehoop on 2016. 3. 17..
 */
public interface JpaRepository<T,ID>  {
    T save(T obj);

    T update(ID id, T obj);

    List<T> findAll();

    T findOne(ID id);

    void delete(ID id);
}
