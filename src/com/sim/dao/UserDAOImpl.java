package com.sim.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sim.model.User;
import com.sim.utility.HibernateUtility;

public class UserDAOImpl implements UserDAO {

	Session session = HibernateUtility.getSession();
	@Override
	public void addUser(User user) {
		session.beginTransaction();
		session.save(user);
		session.beginTransaction().commit();
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));		
		criteria.setMaxResults(1);
		return (User) (criteria.uniqueResult());
	}

}