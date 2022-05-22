package com.bharath.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

// The key annotation is the @WebService, the rest of the annotations are optional
@WebService(name="PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name="response")PaymentProcessorResponse processPayment(
			@WebParam(name="paymentProcessorRequest")PaymentProcessorRequest paymentProcessorRequest);
}
