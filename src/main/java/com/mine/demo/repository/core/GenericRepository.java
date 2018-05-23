package com.mine.demo.repository.core;

import java.io.Serializable;
import java.util.List;

import com.mine.demo.repository.exception.RepositoryException;

public interface GenericRepository<T> {

	public Serializable save(T bean) throws RepositoryException;

	public void update(T bean) throws RepositoryException;

	public T get(Serializable id) throws RepositoryException;

	public List<T> findAll() throws RepositoryException;

}
