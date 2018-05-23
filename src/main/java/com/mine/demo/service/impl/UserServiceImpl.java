package com.mine.demo.service.impl;

import org.springframework.stereotype.Service;

import com.mine.demo.model.User;
import com.mine.demo.service.UserService;
import com.mine.demo.service.core.impl.GenericServiceImpl;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

}
