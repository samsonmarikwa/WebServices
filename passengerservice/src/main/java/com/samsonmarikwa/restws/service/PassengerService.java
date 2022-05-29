package com.samsonmarikwa.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.samsonmarikwa.restws.model.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml")
public interface PassengerService {
	
	@Path("/passengers")
	@GET
	List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);	// bind query parameters to java method params
	
	@Path("/passengers")
	@POST
	Passenger addPassenger(Passenger passenger);

}
