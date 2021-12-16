package com.poc.converters.converters.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.poc.converters.model.v2.fact.PersonFactV2;
import com.poc.converters.model.v2.vo.PersonVoV2;

@Component
public class PersonConverterV2 {

	private final ConversionService conversionService;

	@Autowired
	public PersonConverterV2(ConversionService conversionService) {

		this.conversionService = conversionService;
	}

	public PersonVoV2 getPersonVoV2(final PersonFactV2 personFactV2) {

		return conversionService.convert(personFactV2, PersonVoV2.class);
	}
}
