package com.mine.demo.repository.impl;

import org.springframework.stereotype.Repository;

import com.mine.demo.model.User;
import com.mine.demo.repository.UserRepository;
import com.mine.demo.repository.core.impl.GenericeRepositoryImpl;

@Repository
public class UserRepositoryImpl extends GenericeRepositoryImpl<User> implements UserRepository {

}
