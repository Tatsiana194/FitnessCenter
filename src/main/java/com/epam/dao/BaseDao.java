package com.epam.dao;

import com.epam.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    List<T> findAll();

    T findById(int id);

    boolean delete(int id);

    boolean create(T t);
}
