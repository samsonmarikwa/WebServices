package com.samsonmarikwa.ws.soap;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileWs {
	
	// Optionally mark the DataHandler param
	void upload(@WebParam(name="file") DataHandler attachment);
	
	DataHandler download();
}
