package com.samsonmarikwa.restwsclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import com.samsonmarikwa.restwsclient.model.Patient;

public class PatientWSClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:8080/restws/services/patientservice/patients/123");
		
		Builder request = target.request();
		
		//Response response = request.get();
		
		// System.out.println(response.getStatus());
		
		Patient patient = request.get(Patient.class);
		
		System.out.println("===============");
		System.out.println(patient);
		
		// Get list of patients
		target = client.target("http://localhost:8080/restws/services/patientservice/patients");
		request = target.request();
		List<Patient> patients = request.get(new GenericType<List<Patient>>() {});
		
		System.out.println("===============");
		System.out.println(patients);
	}

}