package com.samsonmarikwa.ws.soap.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY); // if true, it is a response, if false it is a request
		if(!isResponse) {
			SOAPMessage soapMsg = context.getMessage();
			try {
				SOAPEnvelope envelope = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				Iterator<Node> childElements = header.getChildElements();
				
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Response on the way");
		}
		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
