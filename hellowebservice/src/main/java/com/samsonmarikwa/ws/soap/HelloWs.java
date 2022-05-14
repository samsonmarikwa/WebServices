package com.samsonmarikwa.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
// Marks a Java class as implementing a Web Service, or a Java interface as defining a Web Service interface
public class HelloWs {
	
	@WebMethod
	public String hello() {
		return "Hello";
	}

}
