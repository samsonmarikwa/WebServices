package com.samsonmarikwa.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samsonmarikwa.jaxb.patient.Gender;
import com.samsonmarikwa.jaxb.patient.Insurance;
import com.samsonmarikwa.jaxb.patient.Patient;
import com.samsonmarikwa.jaxb.patient.PaymentType;

@SpringBootApplication
public class JaxbxjcApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(JaxbxjcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JaxbxjcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Patient.class);
		Marshaller marshaller = context.createMarshaller();
		
		Patient patient = new Patient();
		patient.setId(100);
		patient.setName("Lazaro");
		patient.setAge(30);
		patient.getEmails().add("lazaro@gmail.com");
		patient.getEmails().add("lazaro@outlook.com");
		
		// Date conversion to XMLGregorianCalendar
		LocalDateTime localDateTime = LocalDateTime.of(1971, 6, 19, 0, 0);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(zonedDateTime);
		XMLGregorianCalendar dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		
		patient.setDob(dob);
		patient.setGender(Gender.F);
		
		PaymentType pt = new PaymentType();
		Insurance ins = new Insurance();
		ins.setProvider("MetLife");
		ins.setLimit(500);
		pt.setInsurance(ins);
		
		patient.setPayment(pt);
		patient.setPhone("123-456-7890");
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(patient, writer);
		
		log.info("==============");
		log.info("Marshalled: {}", writer.toString());
		log.info("==============");
		
		Unmarshaller unMarshaller = context.createUnmarshaller();
		Object unmarshal = unMarshaller.unmarshal(new StringReader(writer.toString()));
		Patient patientUnmarsalled = (Patient) unmarshal;
		log.info("Patient Name: {}", patientUnmarsalled.getName());
		log.info("Patient Emails: {}", patientUnmarsalled.getEmails());
		
	}

}
