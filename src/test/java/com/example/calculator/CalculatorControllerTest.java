package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.example.calculator.controller.CalculatorController;
import com.example.calculator.dto.CalculatorRQ;
import com.example.calculator.dto.CalculatorRS;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.validator.CalculatorValidator;

public class CalculatorControllerTest {

	@Test
	public void addTest() {
		BigDecimal result = new BigDecimal(15.08);
		
		CalculatorRQ calculatorRQ = CalculatorRQ.builder()
												.number1(new BigDecimal(10.41))
												.number2(new BigDecimal(4.67))
												.build();
		
		CalculatorController calculatorController = new CalculatorController(new CalculatorValidator(),
																			 new CalculatorService());
		ResponseEntity<CalculatorRS> response = calculatorController.add(calculatorRQ);
		
		assertEquals(result, response.getBody().getResponse());
	}

	@Test
	public void addFailTest() {
		BigDecimal result = new BigDecimal(15.08);
		
		CalculatorRQ calculatorRQ = CalculatorRQ.builder()
												.number1(new BigDecimal(10.42))
												.number2(new BigDecimal(4.67))
												.build();
		
		CalculatorController calculatorController = new CalculatorController(new CalculatorValidator(),
																			 new CalculatorService());
		ResponseEntity<CalculatorRS> response = calculatorController.add(calculatorRQ);
		
		assertNotEquals(result, response.getBody().getResponse());
	}
	
	@Test
	public void subtractTest() {
		BigDecimal result = new BigDecimal(5.74);
		
		CalculatorRQ calculatorRQ = CalculatorRQ.builder()
												.number1(new BigDecimal(10.41))
												.number2(new BigDecimal(4.67))
												.build();
		
		CalculatorController calculatorController = new CalculatorController(new CalculatorValidator(),
																			 new CalculatorService());
		ResponseEntity<CalculatorRS> response = calculatorController.subtract(calculatorRQ);
		
		assertEquals(result, response.getBody().getResponse());
	}

	@Test
	public void subtractFailTest() {
		BigDecimal result = new BigDecimal(5.74);
		
		CalculatorRQ calculatorRQ = CalculatorRQ.builder()
												.number1(new BigDecimal(10.42))
												.number2(new BigDecimal(4.67))
												.build();
		
		CalculatorController calculatorController = new CalculatorController(new CalculatorValidator(),
																			 new CalculatorService());
		ResponseEntity<CalculatorRS> response = calculatorController.subtract(calculatorRQ);
		
		assertNotEquals(result, response.getBody().getResponse());
	}
}
