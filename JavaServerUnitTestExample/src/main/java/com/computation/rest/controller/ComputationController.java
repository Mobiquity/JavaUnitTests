package com.computation.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.computation.rest.constants.MessageConstants;
import com.computation.rest.service.ComputationService;
import com.computation.rest.service.SimpleCalculatorService;
import com.computation.rest.validator.InputValidator;
import com.computation.rest.wrapper.ResultWrapper;

@Path("/")
@Component("computationController")
public class ComputationController {

	private static final int VALIDATION_FAILURE = 401;
	
	private static final int SUCCESS_CODE = 200;
	
	@Autowired
	private ComputationService computationService;
	
	@Autowired
	private SimpleCalculatorService simpleCalculatorService;

	/**
	 * This rest method perform arithmetic operation like addition, subtraction, multiplication and division. 
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("arithmetic")
	public Response evaluateArithmeticExpression( @QueryParam("input") String input) {
		String result = computationService.basicAirthmeticOperation(input);
		return createResponse(SUCCESS_CODE, result);
	}

	/**
	 * This rest method convert numeric value into binary equivalent representation. It also validate the input data value passed.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("tobinary")
	public Response convertDecimalToBinary( @QueryParam("input") String input) {
		if(InputValidator.validValueForBinaryConversion(input)) {
			String result = computationService.convertDecimalToBinary(input);
			return createResponse(SUCCESS_CODE, result);
		}
		
		return createResponse(VALIDATION_FAILURE, "Invalid input data or format.");
	}
	
	/**
	 * This rest method convert unit to another compaitable unit type.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("convertmeasure")
	//10 miles + 14 kilometers
	public Response convertUnitAndMeasure( @QueryParam("input") String input) {
		String result = computationService.convertUnitAndMeasure(input);
		return createResponse(SUCCESS_CODE, result);
	}

	/**
	 * This rest method convert unit to another compaitable unit type.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("addition")
	public Response addNumbers(@QueryParam("operand1") String operand1, @QueryParam("operand2") String operand2) {
		Response response = validateOperand(operand1, operand2);
		if(response == null) {
			int result = simpleCalculatorService.add(Integer.parseInt(operand1), Integer.parseInt(operand2));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.ADDITION_RESULT, operand1, operand2, result));
		}
		
		return response;
	}

	/**
	 * This rest method convert unit to another compaitable unit type.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("subtract")
	public Response subtractNumbers(@QueryParam("operand1") String operand1, @QueryParam("operand2") String operand2) {
		Response response = validateOperand(operand1, operand2);
		if(response == null) {
			int result = simpleCalculatorService.subtract(Integer.parseInt(operand1), Integer.parseInt(operand2));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.SUBTRACTION_RESULT, operand1, operand2, result));
		}
		
		return response;
	}
	
	/**
	 * This rest method convert unit to another compaitable unit type.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("multiply")
	public Response multiplyNumbers(@QueryParam("operand1") String operand1, @QueryParam("operand2") String operand2) {
		Response response = validateOperand(operand1, operand2);
		if(response == null) {
			int result = simpleCalculatorService.multiply(Integer.parseInt(operand1), Integer.parseInt(operand2));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.MULTIPLY_RESULT, operand1, operand2, result));
		}
		
		return response;
	}
	
	/**
	 * This rest method convert unit to another compaitable unit type.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("division")
	public Response divisionNumbers(@QueryParam("operand1") String operand1, @QueryParam("operand2") String operand2) {
		Response response = validateOperand(operand1, operand2);
		if(response == null) {
			int result = simpleCalculatorService.divison(Integer.parseInt(operand1), Integer.parseInt(operand2));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.DIVISION_RESULT, operand1, operand2, result));
		}
		
		return response;
	}
	
	/**
	 * A default GET method to check that server is up and REST service is working.
	 * @return
	 */
	@GET
	@Produces(value = MediaType.TEXT_HTML)
	public Response getDefaultPage(){
		return Response.status(SUCCESS_CODE).entity("<h1>Test case demo...</h1>").build();
	}
	
	/**
	 * A method to create response object.
	 * 
	 * @param statusCode
	 * @param message
	 * @return
	 */
	private Response createResponse(int statusCode, String message) {
		ResultWrapper resultWrapper = new ResultWrapper();
		resultWrapper.setResult(message);
		return Response.status(statusCode).entity(resultWrapper).build();
	}
	
	private Response validateOperand(String operand1, String operand2) {
		if(!InputValidator.validIntegerValue(operand1)) {
			return createResponse(VALIDATION_FAILURE, "Operand1 is missing or invlaid integer value.");
		}
		
		if(!InputValidator.validIntegerValue(operand2)) {
			return createResponse(VALIDATION_FAILURE, "Operand2 is missing or invlaid integer value.");
		}
		
		return null;
	}

}
