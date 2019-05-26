package com.exchange.CurrencyExchange.model;

import java.math.BigDecimal;

public class ExchangeOutput {
	private String source;
	private String dest;
	private String date;
	private BigDecimal rate;

	public ExchangeOutput(String source, String dest, String date, BigDecimal rate) {
		this.source = source;
		this.dest = dest;
		this.date = date;
		this.rate = rate;
	}

	public String getSource() {
		return source;
	}

	public String getDest() {
		return dest;
	}

	public String getDate() {
		return date;
	}

	public BigDecimal getRate() {
		return rate;
	}
}
