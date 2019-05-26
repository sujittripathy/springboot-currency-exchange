package com.exchange.CurrencyExchange.model;

import com.exchange.CurrencyExchange.validation.CurrencyValidation;
import lombok.Data;

@Data
public class ExchangeInput {
	@CurrencyValidation(message = "Source currency is not valid")
	private String sourceCurrency;

	@CurrencyValidation(message = "Destination currency is not valid")
	private String destinationCurrency;
}
