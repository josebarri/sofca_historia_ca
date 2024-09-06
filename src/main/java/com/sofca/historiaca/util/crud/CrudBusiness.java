package com.sofca.historiaca.util.crud;

import com.sofca.historiaca.exception.BusinessException;
import com.sofca.historiaca.exception.DaoException;

import java.util.List;
import java.util.UUID;

public interface CrudBusiness<T>  {
    public List<T> selectAll() throws BusinessException;
    public T insert(T t) throws BusinessException;
    public void update(T t) throws BusinessException;
    public T getId(UUID id) throws BusinessException;
    public void deleteId(UUID id) throws BusinessException;


}
