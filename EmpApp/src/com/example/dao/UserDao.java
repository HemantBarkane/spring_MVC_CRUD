package com.example.dao;

import java.util.List;

import com.example.dto.User;

public interface UserDao {
	boolean add(User user);
	boolean remove(int userId);
	boolean update(User user);
	List<User>selectAll();
	User selectById(int userId);
	boolean login(User user);
}
