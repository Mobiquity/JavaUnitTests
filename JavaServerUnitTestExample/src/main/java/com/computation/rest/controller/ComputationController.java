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
	 * This rest method different type of average supported by wolfram alpha.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("average")
	public Response average(@QueryParam("type") String type, @QueryParam("set") String valueSet) {
		Response response = validateAverageParameter(type, valueSet);
		if(response == null) {
			String result = computationService.average(type, valueSet);
			response = createResponse(SUCCESS_CODE, result);
		}
		
		return response;
	}
	
	/**
	 * This rest method execute complex query supported by wolfram alpha.
	 * @param input
	 * @return
	 */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("complex-calc")
	public Response complexCalculation(@QueryParam("query") String query) {
		if(!InputValidator.isEmptyString(query)) {
			String result = computationService.complexCalculation(query);
			return createResponse(SUCCESS_CODE, result);
		}
		
		return createResponse(VALIDATION_FAILURE, "Query type is missing.");
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
	@Path("add")
	public Response addNumbers(@QueryParam("leftOperand") String leftOperand, @QueryParam("rightOperand") String rightOperand) {
		Response response = validateOperand(leftOperand, rightOperand);
		if(response == null) {
			float result = simpleCalculatorService.add(Float.parseFloat(leftOperand), Float.parseFloat(rightOperand));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.ADDITION_RESULT, leftOperand, rightOperand, result));
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
	public Response subtractNumbers(@QueryParam("leftOperand") String leftOperand, @QueryParam("rightOperand") String rightOperand) {
		Response response = validateOperand(leftOperand, rightOperand);
		if(response == null) {
			float result = simpleCalculatorService.subtract(Float.parseFloat(leftOperand), Float.parseFloat(rightOperand));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.SUBTRACTION_RESULT, leftOperand, rightOperand, result));
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
	public Response multiplyNumbers(@QueryParam("leftOperand") String leftOperand, @QueryParam("rightOperand") String rightOperand) {
		Response response = validateOperand(leftOperand, rightOperand);
		if(response == null) {
			float result = simpleCalculatorService.multiply(Float.parseFloat(leftOperand), Float.parseFloat(rightOperand));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.MULTIPLY_RESULT, leftOperand, rightOperand, result));
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
	@Path("divide")
	public Response divisionNumbers(@QueryParam("leftOperand") String leftOperand, @QueryParam("rightOperand") String rightOperand) {
		Response response = validateOperand(leftOperand, rightOperand);
		if(response == null) {
			float result = simpleCalculatorService.divison(Float.parseFloat(leftOperand), Float.parseFloat(rightOperand));
			response = createResponse(SUCCESS_CODE, String.format(MessageConstants.DIVISION_RESULT, leftOperand, rightOperand, result));
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
	
	private Response validateOperand(String leftOperand, String rightOperand) {
		if(!InputValidator.validFloatValue(leftOperand)) {
			return createResponse(VALIDATION_FAILURE, "Left operand is missing or invlaid float value.");
		}
		
		if(!InputValidator.validFloatValue(rightOperand)) {
			return createResponse(VALIDATION_FAILURE, "Right operand is missing or invlaid float value.");
		}
		
		return null;
	}

	private Response validateAverageParameter(String type, String valueSet) {
		if(InputValidator.isEmptyString(type)) {
			return createResponse(VALIDATION_FAILURE, "Average type is missing.");
		}
		if(InputValidator.isEmptyString(valueSet)) {
			return createResponse(VALIDATION_FAILURE, "Value set is missing.");
		}
		if(!InputValidator.isValidValueSet(valueSet)) {
			return createResponse(VALIDATION_FAILURE, "Invalid value set.");
		}
		
		return null;
	}
}
