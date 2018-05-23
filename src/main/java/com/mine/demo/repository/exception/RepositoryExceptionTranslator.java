package com.mine.demo.repository.exception;

public class RepositoryExceptionTranslator {

	public static RepositoryException translate(Exception e) throws RepositoryException {
		throw new RepositoryException(e);
	}
}
