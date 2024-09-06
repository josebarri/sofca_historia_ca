package com.sofca.historiaca.util.crud;

import com.sofca.historiaca.exception.BusinessException;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;

import java.util.List;
import java.util.UUID;

public interface CrudManager<T> {
    public List<T> selectAll() throws ManagerException;
    public T insert(T t) throws ManagerException;
    public void update(T t) throws ManagerException;
    public T getId(UUID id) throws ManagerException;
    public void deleteId(UUID id) throws ManagerException;
}
