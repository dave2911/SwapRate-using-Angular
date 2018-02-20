package com.sim.services;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sim.model.Rates;
import com.sim.dao.*;

public class RateServiceImpl implements RatesService {

	private RatesDAO rateDAO=new RatesDAOImpl();
	@Override
	public void addRates(Rates rates) {
		// TODO Auto-generated method stub
		rateDAO.addRates(rates);
	}

	@Override
	public void updateRate(Rates rates) {
		// TODO Auto-generated method stub
		rateDAO.updateRate(rates);
	}

	@Override
	public List<Rates> getAllRates() {
		// TODO Auto-generated method stub
		return rateDAO.getAllRates();
	}
	
	@Override
	public String getJSON(List<Rates> rates) {
		// TODO Auto-generated method stub
		String json="";
		JSONArray rootObject=new JSONArray();
		for(Rates rate:rates)
		{
			JSONObject obj = new JSONObject();
			obj.put("date",rate.getDate().toString());
			obj.put("last_updated",rate.getLast_updated().toString());
			JSONObject swaprates=new JSONObject();
			swaprates.put("inr",rate.getInr());
			swaprates.put("aus",rate.getAus());
			swaprates.put("cad",rate.getCad());
			swaprates.put("eur",rate.getEur());
			obj.put("rates",swaprates);
			rootObject.add(obj);
		}
		return rootObject.toJSONString();
	}

	@Override
	public Rates getRates(java.sql.Date dt){
		return rateDAO.getRate(dt);
	}

	
}