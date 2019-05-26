package com.exchange.CurrencyExchange.service;

import com.exchange.CurrencyExchange.model.ExchangeOutput;
import com.exchange.CurrencyExchange.model.exchangeratesapi.ExchangeRatesApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExchangeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeService.class);

	/**
	 * https://github.com/exchangeratesapi/exchangeratesapi
	 *
	 * @param src
	 * @param dest
	 */
	public ExchangeOutput getLatestRate(String src, String dest) {
		LOGGER.info("Source : " + src + ", Dest : "+ dest);
		ExchangeOutput exchangeOutput = null;
		try {
			Unirest.setObjectMapper(new ObjectMapper() {
			private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper =
					new com.fasterxml.jackson.databind.ObjectMapper();
				@Override
				public <T> T readValue(String value, Class<T> valueType) {
					try {
						return jacksonObjectMapper.readValue(value, valueType);
					} catch (IOException e) {
						throw new RuntimeException();
					}
				}

				@Override
				public String writeValue(Object value) {
					try {
						return jacksonObjectMapper.writeValueAsString(value);
					} catch (JsonProcessingException e) {
						throw new RuntimeException();
					}
				}
			});

			HttpResponse<ExchangeRatesApiResponse> resObj =
					Unirest.get("https://api.exchangeratesapi.io/latest")
							.queryString("base",src)
							.asObject(ExchangeRatesApiResponse.class);
			ExchangeRatesApiResponse exchangeRatesApiResponse = resObj.getBody();
			exchangeOutput =
						new ExchangeOutput(src, dest, exchangeRatesApiResponse.getDate(),
								exchangeRatesApiResponse.getRates().get(dest));
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return exchangeOutput;
	}
}
