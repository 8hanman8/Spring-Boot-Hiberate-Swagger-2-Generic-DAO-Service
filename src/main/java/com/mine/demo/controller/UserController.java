package com.mine.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mine.demo.model.User;
import com.mine.demo.service.UserService;
import com.mine.demo.service.exception.ServiceException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public boolean save(@RequestBody User user) {
		int d = 0;
		try {
			d = (Integer) userService.save(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return d > 0 ? true : false;

	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		try {
			return userService.get(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/get-all")
	public List<User> getAllUsers() {
		List<User> result = new ArrayList<>();
		try {
			result = userService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
