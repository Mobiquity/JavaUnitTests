package com.computation.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.computation.rest.exception.mapper.ResultNotFoundException;
import com.computation.rest.wrapper.ExceptionWrapper;

@Provider
public class ResultNotFoundExceptionMapper implements ExceptionMapper<ResultNotFoundException>{

	@Override
	public Response toResponse(ResultNotFoundException rnfe) {
 
		ExceptionWrapper exceptionWrapper = new ExceptionWrapper();
		exceptionWrapper.setMessage(rnfe.getExpMessage());
		
		return Response
					.status(500)
					.entity(exceptionWrapper)
					.type(MediaType.APPLICATION_JSON)
					.build();	
	}

}
