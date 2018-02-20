package com.sim.ws;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sim.model.Rates;
import com.sim.services.RateServiceImpl;

@Path("rate")
public class RateRestFul {

	RateServiceImpl rateServiceImpl=new RateServiceImpl();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/allrate")
	public Response findAll() {
		List<Rates> allRates = new ArrayList<>();
		allRates = rateServiceImpl.getAllRates();
		String json = rateServiceImpl.getJSON(allRates);
		return Response.ok(json, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,OPTIONS,HEAD").build();
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/update")
	public Response update(@QueryParam("inr") float inr,@QueryParam("aus") float aus,@QueryParam("cad") float cad,@QueryParam("eur") float eur,@QueryParam("dt") java.sql.Date  dt) {
		String json = "";
		Rates rate=rateServiceImpl.getRates(dt);
		java.sql.Date last_updated_date=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		if(rate!=null){
		System.out.println(rate.getSwap_rate_id());
		rate.setAus(aus);
		rate.setCad(cad);
		rate.setEur(eur);
		rate.setInr(inr);
		rate.setLast_updated(last_updated_date);
		rateServiceImpl.updateRate(rate);
		json="{\"status\":\"success\"}";
		}
		else{
			Rates rates=new Rates();
			java.sql.Date last_updated_date1=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			
			rates.setAus(aus);
			rates.setCad(cad);
			rates.setEur(eur);
			rates.setInr(inr);
			rates.setLast_updated(dt);
			rates.setSwap_rate_id(22);
			rates.setDate(last_updated_date1);
			rateServiceImpl.addRates(rates);
			System.out.println("here");
			json="{\"status\":\"no record found, Added new record\"}";
		
		}
		
		return Response.ok(json, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,OPTIONS,HEAD").build();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/current")
	public Response current() throws JSONException{
		String json="";
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println(date);
		Rates rate=rateServiceImpl.getRates(java.sql.Date.valueOf(date));
		if(rate==null){
			json="{\"status\":\"no data found for the given date\"}";
		}
		else{
			json=getJsonData(rate);
		}
		return Response.ok(json,MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods","GET, POST, DELETE, PUT, OPTIONS, HEAD").build();
	}
	
	public String getJsonData(Rates rate) throws JSONException{
		JSONObject obj=new JSONObject();
		obj.put("date",rate.getDate().toString());
		obj.put("last_updated",rate.getLast_updated().toString());
		JSONObject swaprates=new JSONObject();
		swaprates.put("inr",rate.getInr());
		swaprates.put("aus",rate.getAus());
		swaprates.put("cad",rate.getCad());
		swaprates.put("eur",rate.getEur());
		obj.put("rates",swaprates);
		return obj.toString();
	}
	@POST
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("/upload")
	public Response upload()
	{
		return null;
		
	}
}