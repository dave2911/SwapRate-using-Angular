package com.sim.dao;

import java.sql.Date;
import java.util.List;

import com.sim.model.Rates;

public interface RatesDAO {
	public void addRates(Rates rates);
	public void updateRate(Rates rates);
	public List<Rates> getAllRates();
	Rates getRate(Date dt);
}