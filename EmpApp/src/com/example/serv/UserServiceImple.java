package com.example.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.User;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean add(User user) {
		return userDao.add(user);
	}

	public boolean remove(int userId) {
		
		return userDao.remove(userId);
	}

	public boolean update(User user) {
		
		return userDao.update(user);
	}

	public List<User> selectAll() {
		
		return userDao.selectAll();
	}

	public User select(int userId) {	
		return userDao.selectById(userId);
	}

	@Override
	public boolean login(User user) {
		
		return userDao.login(user);
	}
	

}
