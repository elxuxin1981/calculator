package com.example.calculator.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.calculator.dto.ErrorValidatorDTO;
import com.example.calculator.exception.CalculatorException;

import io.corp.calculator.TracerImpl;

@ControllerAdvice
public class CalculatorExceptionHandler {

	@ExceptionHandler(CalculatorException.class)
	ResponseEntity<ErrorValidatorDTO> calculatorExceptionHandler(CalculatorException ex) {

		ResponseEntity<ErrorValidatorDTO> response = new ResponseEntity<>(new ErrorValidatorDTO(HttpStatus.EXPECTATION_FAILED.value(), ex.getMessage()),
				HttpStatus.EXPECTATION_FAILED);
		
		TracerImpl tracer = new TracerImpl();
		tracer.trace(response);

		return response;
	}
}
