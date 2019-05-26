package com.exchange.CurrencyExchange.model.exchangeratesapi;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRatesApiResponse {
	private String base;
	private Map<String, BigDecimal> rates;
	private String date;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
