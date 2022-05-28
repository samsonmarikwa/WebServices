package com.samsonmarikwa.restwsclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.samsonmarikwa.restwsclient.model.Patient;

public class PatientWSClient {

	private static final String PATIENTS = "/patients";
	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 123);	
		Builder request = target.request();
		
		//Response response = request.get();	
		// System.out.println(response.getStatus());
		
		// Get a patient
		Patient patient = request.get(Patient.class);	
		System.out.println("===============");
		System.out.println(patient);
		
		// Update Patient
		patient.setName("Annet Leonard");
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println(updateResponse.getStatus());
		// Cleanup resources
		updateResponse.close();
		
		// Create new patient
		Patient newPatient = new Patient();
		newPatient.setName("Tadisa Kanakembizi");
		WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Patient createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML), Patient.class);
		System.out.println("===============");
		System.out.println(createdPatient);
		
		// Get list of patients
		WebTarget getTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Builder getRequest = getTarget.request();
		List<Patient> patients = getRequest.get(new GenericType<List<Patient>>() {});
		System.out.println("===============");
		System.out.println(patients);
		
		// Delete a patient
		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 123);
		Builder deleteRequest = deleteTarget.request();
		Response deleteResponse = deleteRequest.delete();
		System.out.println("===============");
		System.out.println("Delete Status: " + deleteResponse.getStatus());
		deleteResponse.close();		
		
		// Clean up resources	
		client.close();
	}

}
