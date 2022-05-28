package com.samsonmarikwa.restws.service;

import java.util.List;

import com.samsonmarikwa.restws.model.Passenger;

public interface PassengerService {
	
	List<Passenger> getPassengers();
	
	Passenger addPassenger();

}
