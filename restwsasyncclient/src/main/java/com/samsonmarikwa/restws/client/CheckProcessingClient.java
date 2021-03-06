package com.samsonmarikwa.restws.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.samsonmarikwa.restws.model.ChecksList;

public class CheckProcessingClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restwsasync/services/checkprocessingservice/checks");
		AsyncInvoker invoker = target.request().async();
		// InvocationCallback is another way to implement an asynchronous callback
		
		// An empty ChecksList is being sent. This will cause an exception to be thrown from the server logic.
		Future<Boolean> response = invoker.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML), Boolean.class);
		
		try {
			System.out.println(response.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			// Handling the BadRequestException
			if (e.getCause() instanceof BadRequestException) {
				BadRequestException bre = (BadRequestException) e.getCause();	// get exception information // exceptions can be handled at the server where appropriate
				System.out.println("Please send a valid list of checks");
			}
		}

	}

}
