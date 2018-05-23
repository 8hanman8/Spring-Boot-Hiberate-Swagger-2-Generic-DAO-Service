package com.mine.demo.service.core.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mine.demo.repository.core.GenericRepository;
import com.mine.demo.repository.exception.RepositoryException;
import com.mine.demo.service.core.GenericService;
import com.mine.demo.service.exception.ServiceException;
import com.mine.demo.service.exception.ServiceExceptionTranslator;

@Service
@Transactional
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	private GenericRepository<T> genericService;

	@Override
	public Serializable save(T bean) throws ServiceException {
		try {
			return genericService.save(bean);
		} catch (RepositoryException e) {
			ServiceExceptionTranslator.translate(e);
		}
		return null;
	}

	@Override
	public void update(T bean) throws ServiceException {
		try {
			genericService.update(bean);
		} catch (Exception e) {
			ServiceExceptionTranslator.translate(e);
		}

	}

	@Override
	public T get(Serializable id) throws ServiceException {
		try {
			return genericService.get(id);
		} catch (Exception e) {
			ServiceExceptionTranslator.translate(e);
		}
		return null;
	}

	@Override
	public List<T> findAll() throws ServiceException {
		List<T> result=new ArrayList<>();
		try {
			result= genericService.findAll();
		} catch (Exception e) {
			ServiceExceptionTranslator.translate(e);
		}
		return result;
	}

}
