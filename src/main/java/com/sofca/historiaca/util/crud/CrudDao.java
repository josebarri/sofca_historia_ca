package com.sofca.historiaca.util.crud;

import com.sofca.historiaca.exception.DaoException;

import java.util.List;
import java.util.UUID;

public interface CrudDao<T> {
    public List<T> selectAll() throws DaoException;
    public T insert(T t) throws DaoException;
    public T getId(UUID id) throws DaoException;
    public void update(T t) throws DaoException;
    public void deleteId(UUID id) throws DaoException;
}
