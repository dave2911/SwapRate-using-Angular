package com.sim.services;

import java.sql.Date;
import java.util.List;

import com.sim.model.Rates;
import com.sim.model.User;

public interface RatesService {
	public void addRates(Rates rates);
	public void updateRate(Rates rates);
	public List<Rates> getAllRates();
	public String getJSON(List<Rates> rates);
	Rates getRates(Date dt);
}
