package com.mine.demo.repository.core.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import com.mine.demo.repository.core.GenericRepository;
import com.mine.demo.repository.exception.RepositoryException;

@Repository
public abstract class GenericeRepositoryImpl<T> implements GenericRepository<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> _class;

	@SuppressWarnings("unchecked")
	public GenericeRepositoryImpl() {
		this._class = ((Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericeRepositoryImpl.class));
	}

	@Override
	public Serializable save(T bean) {
		Session session = sessionFactory.getCurrentSession();
		return session.save(bean);
	}

	@Override
	public void update(T bean) throws RepositoryException {
		Session session = sessionFactory.getCurrentSession();
		session.update(bean);

	}

	@Override
	public T get(Serializable id) throws RepositoryException {
		Session session = sessionFactory.getCurrentSession();
		return session.get(_class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws RepositoryException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM " + _class.getName()).list();
	}

}
