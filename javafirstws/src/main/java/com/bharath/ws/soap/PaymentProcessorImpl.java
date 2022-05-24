package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		// Fault code
		if (paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null
				|| paymentProcessorRequest.getCreditCardInfo().getCardNumber().length() == 0) {
			throw new RuntimeException("Card number cannot be empty");
		}
		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
