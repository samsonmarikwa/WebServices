package com.clinicals.api.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicals.api.model.Patient;
import com.clinicals.api.repos.PatientRepo;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
public class PatientService {
	
	@Autowired
	PatientRepo repo;
	
	@Path("/patients")
	@POST
	public Patient createPatient(Patient patient) {
		return repo.save(patient);
	}
	
	@Path("/patient/{id}")
	@GET
	public Patient getPatient(@PathParam("id") int id) {
		return repo.findById(id).get();
	}
	
	@Path("/patients")
	@GET
	public List<Patient> getPatients() {
		return repo.findAll();
	}

}
