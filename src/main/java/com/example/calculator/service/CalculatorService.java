package com.example.calculator.service;

import org.springframework.stereotype.Service;

import com.example.calculator.dto.CalculatorRQ;
import com.example.calculator.dto.CalculatorRS;

@Service
public class CalculatorService {

	public CalculatorRS add(CalculatorRQ calculatorRQ) {

		return CalculatorRS.builder()
						   .response(calculatorRQ.getNumber1().add(calculatorRQ.getNumber2()))
						   .build();
	}

	public CalculatorRS subtract(CalculatorRQ calculatorRQ) {

		return CalculatorRS.builder()
						   .response(calculatorRQ.getNumber1().subtract(calculatorRQ.getNumber2()))
						   .build();
	}
}
