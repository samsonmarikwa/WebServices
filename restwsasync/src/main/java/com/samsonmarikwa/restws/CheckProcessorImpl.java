package com.samsonmarikwa.restws;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.samsonmarikwa.restws.model.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		//logic
		// typically Async methods implement multithreads, which allows the checks to be quickly proceesed in several threads.
		new Thread() {
			public void run() {
				response.resume(true);		
			}
		}.start();
	}

}
