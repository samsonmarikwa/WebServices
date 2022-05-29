package com.samsonmarikwa.restws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.samsonmarikwa.restws.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	List<Passenger> passengers = new ArrayList<>();
	int currentId = 123;
	

	@Override
	public List<Passenger> getPassengers(int start, int size) {
		System.out.println("start: " + start);
		System.out.println("size: " + size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println("firstName: " + firstName);
		System.out.println("lastName: " + lastName);
		
		System.out.println("Agent: " + agent);
		
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> headerKeys = allHeaders.keySet();
		for (String key : headerKeys) {
			System.out.println(key + ", " + headers.getHeaderString(key));			
		}
	}

}
