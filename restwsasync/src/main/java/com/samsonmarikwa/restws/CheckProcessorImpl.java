package com.samsonmarikwa.restws;

import javax.ws.rs.container.AsyncResponse;

import com.samsonmarikwa.restws.model.ChecksList;

public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		//logic
		response.resume(true);
	}

}
