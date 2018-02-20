package com.sim.dao;

import com.sim.model.User;

public interface UserDAO {
	public void addUser(User user);
	public void removeUser(User user);
	public User getUser(String userName);
}