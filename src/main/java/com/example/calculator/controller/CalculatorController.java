package com.example.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.dto.CalculatorRQ;
import com.example.calculator.dto.CalculatorRS;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.validator.CalculatorValidator;

import io.corp.calculator.TracerImpl;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalculatorValidator calculatorValidator;

	@Autowired
	private CalculatorService calculatorService;

	
	public CalculatorController(CalculatorValidator calculatorValidator,
			CalculatorService calculatorService) {
		this.calculatorValidator = calculatorValidator;
		this.calculatorService = calculatorService;
	}

	@PostMapping("/add")
    public ResponseEntity<CalculatorRS> add(@RequestBody CalculatorRQ calculatorRQ) {
		calculatorValidator.validate(calculatorRQ, null);
		
		ResponseEntity<CalculatorRS> response = new ResponseEntity<>(calculatorService.add(calculatorRQ), HttpStatus.OK);

		TracerImpl tracer = new TracerImpl();
		tracer.trace(response);

		return response;
    }

	@PostMapping("/subtract")
	public ResponseEntity<CalculatorRS> subtract(@RequestBody CalculatorRQ calculatorRQ) {
		calculatorValidator.validate(calculatorRQ, null);

		ResponseEntity<CalculatorRS> response = new ResponseEntity<>(calculatorService.subtract(calculatorRQ), HttpStatus.OK);

		TracerImpl tracer = new TracerImpl();
		tracer.trace(response);

		return response;
	}
}
