package com.clinicals.api.endpoints;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicals.api.model.ClinicalData;
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
	
	@Path("/patients/{id}")
	@GET
	public Patient getPatient(@PathParam("id") int id) {
		return repo.findById(id).get();
	}
	
	@Path("/patients")
	@GET
	public List<Patient> getPatients() {
		return repo.findAll();
	}
	
	@Path("/patients/analyze/{id}")
	@GET
	public Patient analyze(@PathParam("id") int id) {
		Optional<Patient> optionalPatient = repo.findById(id);
		Patient patient = null;
		
		if (optionalPatient.isPresent()) {
			patient = optionalPatient.get();
		} else {
			throw new NotFoundException();
		}
		
		List<ClinicalData> clinicalData = new ArrayList<>(patient.getClinicalData());
		for (ClinicalData eachEntry : clinicalData) {
			if(eachEntry.getComponentName().equalsIgnoreCase("hw")) {
				String[] heightAndWeight = eachEntry.getComponentValue().split("/");
				String height = heightAndWeight[0];
				String weight = heightAndWeight[1];
				
				float heightInMetres = Float.parseFloat(height) * 0.4536F; // from feet to metres
				float bmi = Float.parseFloat(weight) / (heightInMetres * heightInMetres);
				ClinicalData bmiData = new ClinicalData();
				bmiData.setComponentName("bmi");
				bmiData.setComponentValue(String.valueOf(bmi));
				bmiData.setMeasuredDateTime(new Timestamp(System.currentTimeMillis()));
				patient.getClinicalData().add(bmiData);
			}
		}
		return patient;
		
	}

}
