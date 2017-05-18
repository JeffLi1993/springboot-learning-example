package cn.ictgu.mongo.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import cn.ictgu.mongo.model.User;

/**
 * User Service Created by Silence on 2017/4/22.
 */
@Service
public class UserService {

	private final ConcurrentHashMap<String, User> users;

	public UserService() {
		users = new ConcurrentHashMap<>();
	}

	public boolean addUser(User user) {
		boolean isExist = users.containsKey(user.getUsername());
		if (isExist) {
			return false;
		}
		users.put(user.getUsername(), user);
		return true;
	}

	public User getByUsername(String username) {
		return users.get(username);
	}

}
