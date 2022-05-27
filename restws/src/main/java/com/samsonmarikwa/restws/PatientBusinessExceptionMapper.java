package com.samsonmarikwa.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samsonmarikwa.restws.exception.PatientBusinessException;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {
	Logger logger = LoggerFactory.getLogger(PatientBusinessExceptionMapper.class);

	@Override
	public Response toResponse(PatientBusinessException exception) {
		logger.info("Exception: {}", exception.getMessage());
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Try Again Later\"");
		sb.append("}");
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
