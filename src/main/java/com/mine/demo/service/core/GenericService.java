package com.mine.demo.service.core;

import java.io.Serializable;
import java.util.List;

import com.mine.demo.service.exception.ServiceException;

public interface GenericService<T> {

	public Serializable save(T bean) throws ServiceException;

	public void update(T bean) throws ServiceException;

	public T get(Serializable id) throws ServiceException;

	public List<T> findAll() throws ServiceException;

}
