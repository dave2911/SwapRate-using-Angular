package com.sim.services;

import com.sim.dao.UserDAO;
import com.sim.dao.UserDAOImpl;
import com.sim.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO=new UserDAOImpl();
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		userDAO.removeUser(user);
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return userDAO.getUser(userName);
	}

}