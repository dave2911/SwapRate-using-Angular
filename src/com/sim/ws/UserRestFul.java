package com.sim.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sim.model.User;
import com.sim.services.UserServiceImpl;

@Path("user")
public class UserRestFul {

	private UserServiceImpl userService=new UserServiceImpl();
	
	@SuppressWarnings("unused")
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/login")
	public Response login(@QueryParam("username") String username,
			@QueryParam("pass") String pass){
		System.out.println(username+" "+pass);	
		
		User user=userService.getUser(username);
		String json="";
		System.out.println(user.getUsername());
		
		if(user!=null){
			if(user.getPassword().equals(pass))
				json="{\"status\":\"success\"}";
			else
				json="{\"status\":\"wrong credential\"}";
		}
		else
		{
			json="{\"status\":\"invalid user\"}";	
		}
		
		return Response.ok(json,MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods","GET, POST, DELETE, PUT,OPTIONS,HEAD")
				.build();
	}
}
