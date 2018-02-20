package com.sim.fun;

import com.sim.model.Rates;
import com.sim.model.User;
import com.sim.services.RateServiceImpl;
import com.sim.services.UserService;
import com.sim.services.UserServiceImpl;
import com.sim.utility.HibernateUtility;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class Testing {
	public static void main(String[] args) {
	/*	User user=new User();
		user.setUsername("fasosoo");
		user.setUser_id(4512);
		user.setRole("admin");
		user.setPassword("fooooo");
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		userServiceImpl.addUser(user);
		*/
		RateServiceImpl rateServiceImpl=new RateServiceImpl();
		/*List<Rates> ll=rateServiceImpl.getAllRates();
		for(Rates r:ll)
			System.out.println(r.getAus()+" "+r.getDate());*/
	/*	System.out.println("done");
		
		System.out.println(rateServiceImpl.getRates(java.sql.Date.valueOf("2018-01-22")).getAus());
	
		Rates rate=rateServiceImpl.getRates(java.sql.Date.valueOf("2018-01-22"));
		Rates rt=new Rates();
		System.out.println(rate.getSwap_rate_id());
		rt.setSwap_rate_id(rate.getSwap_rate_id());
		rate.setAus(23.5f);
		rateServiceImpl.updateRate(rate);
		*/
	/*	Rates rate=rateServiceImpl.getRates(java.sql.Date.valueOf("2018-01-22"));
		System.out.println(rate.getAus()+" "+rate.getCad()+" "+rate.getDate()+" "+rate.getSwap_rate_id());
		List<Rates> ll=rateServiceImpl.getAllRates();
		for(Rates r:ll)
			System.out.println(r.getAus()+" "+r.getDate());
		rate.setAus(45.5f);
		rateServiceImpl.updateRate(rate);
		
		Rates rates=rateServiceImpl.getRates(java.sql.Date.valueOf("2018-01-22"));
		System.out.println(rates.getAus()+" "+rates.getCad()+" "+rates.getDate()+" "+rates.getSwap_rate_id());
		*/
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println(date);
		Rates rate=rateServiceImpl.getRates(java.sql.Date.valueOf(date));
		if(rate==null)
		{
			System.out.println("null value");
		}
	}
}