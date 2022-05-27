package com.samsonmarikwa.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.samsonmarikwa.restws.model.Patient;

@Consumes("application/xml,application/json")	// you should specify type of data as json
@Produces("application/xml,application/json")	// you still need to send Accept application/json in the header as it defaults to xml
@Path("/patientservice")
public interface PatientService {
	// localhost:8080/restws/services/patientservice/patients
	// By default cxf exposes all endpoints on services/ after the context path
	@Path("/patients")
	@GET
	List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam(value = "id") Long id);
	
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam(value = "id") Long id);

}
