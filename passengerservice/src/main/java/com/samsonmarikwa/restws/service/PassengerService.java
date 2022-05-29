package com.samsonmarikwa.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.samsonmarikwa.restws.model.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml, application/x-www-form-urlencoded")
public interface PassengerService {
	
	@Path("/passengers")
	@GET
	List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);	// bind query parameters to java method params
	
	@Path("/passengers")
	@POST
	void addPassenger(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,	// bind form values to java method params
			@HeaderParam("agent") String agent);	// bind Header values to java method params

}
