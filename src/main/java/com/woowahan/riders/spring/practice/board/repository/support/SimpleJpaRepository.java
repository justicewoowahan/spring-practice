package com.woowahan.riders.spring.practice.board.repository.support;

import com.woowahan.riders.spring.practice.board.repository.support.sequence.SequenceGenerator;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by justicehoop on 2016. 3. 17..
 */
public class SimpleJpaRepository<T, ID extends Serializable> implements JpaRepository<T,ID> {

    private Map<ID,T> dataMap = new HashMap<>();
    private SequenceGenerator<ID> sequenceGenerator;

    public SimpleJpaRepository() {
    }

    public void setSequenceGenerator(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public T save(T obj)  {
        ID id = sequenceGenerator.generate();
        assignId(id, obj);

        return dataMap.put(id, obj);
    }

    private void assignId(ID id, T obj) {
        Method idSetter = null;
        try {
            idSetter = ReflectionUtils.findMethod(obj.getClass(),"setId", Long.class);
            if (!idSetter.isAccessible()) {
                idSetter.setAccessible(true);
            }
            idSetter.invoke(obj,id);
        } catch (InvocationTargetException e) {
            throw new AssignIdFailedException("failed to assign id cause InvocationTargetException!", e);
        } catch (IllegalAccessException e) {
            throw new AssignIdFailedException("failed to assign id cause IllegalAccessException!", e);
        }

    }

    @Override
    public T update(ID id, T obj) {
        T savedObj = dataMap.get(id);
        if (savedObj == null) {
            throw new IllegalStateException("entity for [id:" + id + "] does not exist!!");
        }
        return dataMap.put(id,obj);
    }

    @Override
    public List<T> findAll() {
        List<T> datas = new ArrayList<>();

        for (Map.Entry<ID, T> entry : dataMap.entrySet()) {
            datas.add(entry.getValue());
        }
        return datas;

    }

    @Override
    public T findOne(ID id) {
        T savedObj = dataMap.get(id);
        if (savedObj == null) {
            return null;
        }
        return savedObj;
    }

    @Override
    public void delete(ID id) {
        dataMap.remove(id);
    }

}
