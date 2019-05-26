package com.exchange.CurrencyExchange.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {CurrencyValidator.class})
public @interface CurrencyValidation {

	String message() default "{com.exchange.CurrencyExchange.validation.CurrencyValidation.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
