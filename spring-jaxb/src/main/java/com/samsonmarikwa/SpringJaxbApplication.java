package com.samsonmarikwa;

import java.io.StringWriter;
import java.util.UUID;

import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.samsonmarikwa.orders.Order;
import com.samsonmarikwa.orders.Order.Address;

@SpringBootApplication
public class SpringJaxbApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(SpringJaxbApplication.class);
	
	@Autowired
	private Jaxb2Marshaller marshaller;

	public static void main(String[] args) {
		SpringApplication.run(SpringJaxbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Order order = new Order();
		order.setOrderId(UUID.randomUUID().toString());
		order.setProduct("Colgate Toothpaste");
		
		Address address = new Address();
		address.setName("Annet");
		address.setAddress("Address line1");
		address.setCity("Charlotte");
		address.setCountry("USA");
		order.setAddress(address);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(order, new StreamResult(writer));
		
		String xml = writer.toString();
		log.info("XML: {}", xml);
		
	}
	
	

}
