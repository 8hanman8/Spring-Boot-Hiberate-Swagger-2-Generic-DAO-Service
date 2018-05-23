package com.mine.demo.service.exception;

public class ServiceExceptionTranslator {

	public static ServiceException translate(Exception e) throws ServiceException {
		throw new ServiceException(e);
	}
}
