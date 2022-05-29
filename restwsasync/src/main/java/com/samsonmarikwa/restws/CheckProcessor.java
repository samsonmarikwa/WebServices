package com.samsonmarikwa.restws;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.samsonmarikwa.restws.model.ChecksList;

@Path("/checkprocessingservice")
public interface CheckProcessor {
	
	@POST
	@Path("/checks")
	public Boolean processChecks(ChecksList checksList);	// a wrapper class has been used to wrap a list of checks. This is a good practice.

}
