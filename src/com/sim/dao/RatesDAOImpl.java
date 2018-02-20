package com.sim.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sim.model.Rates;
import com.sim.model.User;
import com.sim.utility.HibernateUtility;

public class RatesDAOImpl implements RatesDAO {

	Session session = HibernateUtility.getSession();
	@Override
	public void addRates(Rates rates) {
		session.save(rates);
		session.beginTransaction().commit();
	}

	@Override
	public void updateRate(Rates rates) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(rates);
		session.beginTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rates> getAllRates() {
		return session.createQuery("from Rates").list();
	}
	
	@Override
	public Rates getRate(java.sql.Date dt){
		Criteria criteria=session.createCriteria(Rates.class);
		criteria.add(Restrictions.eq("date", dt));		
		return (Rates) criteria.uniqueResult();
	}
}