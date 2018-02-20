package com.sim.ws;

import com.sim.test.*;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
public class ProductRestFull {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find")
	public Response findAll(){
		List<Product> products=new ArrayList<Product>();
		products.add(new Product(1,"sample",23.5,5));
		products.add(new Product(2,"tample",33.5,6));
		products.add(new Product(3,"uample",43.5,7));
		products.add(new Product(4,"vample",53.5,8));
		products.add(new Product(5,"wample",63.5,9));
		return Response.ok().entity(new GenericEntity<List<Product>>(products) {})
				.header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods","GET, POST, DELETE, PUT,OPTIONS,HEAD")
				.build();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/login")
	public Response login(@QueryParam("param1") String param1,
			@QueryParam("param2") String param2){
			System.out.println("passed"+param1+" "+param2);
			String json="{\"status\":\"ok\"}";
		return Response.ok(json,MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods","GET, POST, DELETE, PUT,OPTIONS,HEAD")
				.build();
	}
	
	
/*	public List<Product> findAll(){
		List<Product> products=new ArrayList<Product>();
		products.add(new Product(1,"sample",23.5,5));
		products.add(new Product(2,"tample",33.5,6));
		products.add(new Product(3,"uample",43.5,7));
		products.add(new Product(4,"vample",53.5,8));
		products.add(new Product(5,"wample",63.5,9));
		return products;
	}*/
	
	
}