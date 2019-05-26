package com.exchange.CurrencyExchange.model;

import com.exchange.CurrencyExchange.validation.CurrencyValidation;
import lombok.Data;

@Data
public class ExchangeInput {
	@CurrencyValidation
	private String sourceCurrency;

	@CurrencyValidation
	private String destinationCurrency;
}
