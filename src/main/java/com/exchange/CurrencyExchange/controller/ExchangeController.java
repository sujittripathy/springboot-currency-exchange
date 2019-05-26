package com.exchange.CurrencyExchange.controller;

import com.exchange.CurrencyExchange.model.ExchangeInput;
import com.exchange.CurrencyExchange.model.ExchangeOutput;
import com.exchange.CurrencyExchange.service.ExchangeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExchangeController {

	private final ExchangeService exchangeService;

	public ExchangeController(ExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}

	@GetMapping(value = "/find-rate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ExchangeOutput getLatestRate(@RequestParam("src") String src,
	                                    @RequestParam("dest") String dest) {
		return exchangeService.getLatestRate(src, dest);
	}

	@PostMapping(value = "/find-rate-post", produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public ExchangeOutput getLatestRatePost(@Valid @RequestBody ExchangeInput input) {
		return exchangeService.getLatestRate(input.getSourceCurrency(), input.getDestinationCurrency());
	}
}
