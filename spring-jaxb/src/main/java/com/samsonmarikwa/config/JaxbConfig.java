package com.samsonmarikwa.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JaxbConfig {
	
	@Bean
	// The bean will perform marshalling to XML and unmarshalling to POJO as well as schema validation
	public Jaxb2Marshaller createJaxb2Marshaller(@Value("${context.path}") final String contextPath,
			@Value("${schema.location}") final Resource schemaResource) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(contextPath);
		marshaller.setSchema(schemaResource);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.setMarshallerProperties(properties);
		return marshaller;
		
	}
}
