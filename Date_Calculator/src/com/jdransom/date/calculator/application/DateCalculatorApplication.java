package com.jdransom.date.calculator.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.jdransom.date.calculator.model.JsonProcessingExceptionMapper;

public class DateCalculatorApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public DateCalculatorApplication() {
		singletons.add(new JacksonJsonProvider());
		singletons.add(new JsonProcessingExceptionMapper());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
