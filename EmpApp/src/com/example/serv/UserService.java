package com.example.serv;

import java.util.List;

import com.example.dto.User;

public interface UserService {
	boolean add(User user);
	boolean remove(int userId);
	boolean update(User user);
	List<User> selectAll();
	User select(int userId);
	boolean login(User user);
}
