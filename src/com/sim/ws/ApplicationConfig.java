package com.sim.ws;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>>  resources=new java.util.HashSet<>();
		addRestResourcesClasses(resources);
		return resources;
	}

	private void addRestResourcesClasses(Set<Class<?>> resources) {
		// TODO Auto-generated method stub
		resources.add(com.sim.ws.ProductRestFull.class);
		resources.add(com.sim.ws.RateRestFul.class);
		resources.add(com.sim.ws.UserRestFul.class);
	}
	
}
