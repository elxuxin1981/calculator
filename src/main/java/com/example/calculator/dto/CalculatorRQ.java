package com.example.calculator.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorRQ {

	/**
	 * the number1
	 */
	private BigDecimal number1;

	/**
	 * the numbre2
	 */
    private BigDecimal number2;
}