package com.samsonmarikwa.restws.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.ServiceUnavailableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.samsonmarikwa.restws.exception.PatientBusinessException;
import com.samsonmarikwa.restws.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 123;

	public PatientServiceImpl() {
		init();
	}
	
	void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Patient getPatient(Long id) throws ServiceUnavailableException {
		if(patients.get(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
			//throw new ServiceUnavailableException();
		}
		return patients.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		
		Patient currentPatient = patients.get(patient.getId());
		
		Response response = null;
		if (currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			//response = Response.notModified().build();
			throw new PatientBusinessException();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		
		Patient currentPatient = patients.get(id);
		
		Response response = null;
		if (currentPatient != null) {
			patients.remove(id);
			response = Response.status(204).build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}
	

}
