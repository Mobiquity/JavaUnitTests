package com.computation.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.computation.rest.service.ComputationService;
import com.computation.rest.validator.InputValidator;
import com.computation.rest.wrapper.ResultWrapper;

@Path("/")
@Component("computationController")
public class ComputationController {

	private static final int VALIDATION_FAILURE = 401;
	
	private static final int SUCCESS_CODE = 200;
	
	@Autowired
	private ComputationService computationService;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("arithmetic")
	public Response evaluateArithmeticExpression( @QueryParam("input") String input) {
		String result = computationService.basicAirthmeticOperation(input);
		return createResponse(SUCCESS_CODE, result);
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("tobinary")
	public Response convertDecimalToBinary( @QueryParam("input") String input) {
		if(InputValidator.validValueForBinaryConversion(input)) {
			String result = computationService.convertDecimalToBinary(input);
			return createResponse(SUCCESS_CODE, result);
		}
		
		return createResponse(VALIDATION_FAILURE, "Invlaid input data or format.");
	}
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("convertmeasure")
	//10 miles + 14 kilometers
	public Response convertUnitAndMeasure( @QueryParam("input") String input) {
		String result = computationService.convertUnitAndMeasure(input);
		return createResponse(SUCCESS_CODE, result);
	}

	@GET
	@Produces(value = MediaType.TEXT_HTML)
	public Response getDefaultPage(){
		return Response.status(SUCCESS_CODE).entity("<h1>Test case demo...</h1>").build();
	}
	
	private Response createResponse(int statusCode, String message) {
		ResultWrapper resultWrapper = new ResultWrapper();
		resultWrapper.setResult(message);
		return Response.status(statusCode).entity(resultWrapper).build();
	}

}
