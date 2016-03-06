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
import com.computation.rest.wrapper.ResultWrapper;

@Path("/")
@Component("computationController")
public class ComputationController {

//	@Autowired
//	private ComputationEngine computationEngine; // = new ComputationEngine("Q6VYUE-95GGAX4U8Q", "plaintext");

	@Autowired
	private ComputationService computationService; // = new ComputationServiceImpl(computationEngine);

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("arithmetic")
	public Response evaluateArithmeticExpression( @QueryParam("input") String input) {
		String result = computationService.basicAirthmeticOperation(input);
		ResultWrapper resultWrapper = new ResultWrapper();
		resultWrapper.setResult(result);
		return Response.status(200).entity(resultWrapper).build();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("tobinary")
	public Response convertDecimalToBinary( @QueryParam("input") String input) {
		String result = computationService.convertDecimalToBinary(input);
		ResultWrapper resultWrapper = new ResultWrapper();
		resultWrapper.setResult(result);
		return Response.status(200).entity(resultWrapper).build();
	}

	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("convertmeasure")
	//10 miles + 14 kilometers
	public Response convertUnitAndMeasure( @QueryParam("input") String input) {
		String result = computationService.convertUnitAndMeasure(input);
		ResultWrapper resultWrapper = new ResultWrapper();
		resultWrapper.setResult(result);
		return Response.status(200).entity(resultWrapper).build();
	}

	
}
