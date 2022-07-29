package com.example.calculator.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.calculator.dto.CalculatorRQ;
import com.example.calculator.exception.CalculatorException;

@Component
public class CalculatorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CalculatorRQ.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CalculatorRQ calculatorRQ = (CalculatorRQ) target;
		if (!isBigDecimal(calculatorRQ.getNumber1())) {
			throw new CalculatorException("El número 1 no es válido");
		}

		if (!isBigDecimal(calculatorRQ.getNumber2())) {
			throw new CalculatorException("El número 2 no es válido");
		}
	}

	private boolean isBigDecimal(BigDecimal number) {
		boolean isBigDecimal = false;
		if (number != null) {
			isBigDecimal = true;
		}

		return isBigDecimal;
	}
}
