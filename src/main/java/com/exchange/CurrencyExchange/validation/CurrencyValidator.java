package com.exchange.CurrencyExchange.validation;

import org.springframework.beans.factory.annotation.Value;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@DomainValidation
public class CurrencyValidator implements ConstraintValidator<CurrencyValidation, String> {

	@Value("${allowed.currencies}")
	private String currencies;

	@Override
	public void initialize(CurrencyValidation constraintAnnotation) {
		System.out.println(constraintAnnotation.message());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.matches(currencies);
	}
}
