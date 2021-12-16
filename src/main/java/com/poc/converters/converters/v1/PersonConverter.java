package com.poc.converters.converters.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.poc.converters.model.v1.fact.PersonFact;
import com.poc.converters.model.v1.vo.PersonVo;

@Component
public class PersonConverter {

	private final ConversionService conversionService;

	@Autowired
	public PersonConverter(ConversionService conversionService) {

		this.conversionService = conversionService;
	}

	public PersonVo getPersonVo(final PersonFact personFact) {

		return conversionService.convert(personFact, PersonVo.class);
	}
}
