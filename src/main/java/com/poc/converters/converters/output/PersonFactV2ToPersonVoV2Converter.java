package com.poc.converters.converters.output;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.poc.converters.model.v2.fact.PersonFactV2;
import com.poc.converters.model.v2.vo.PersonVoV2;

@Component
public class PersonFactV2ToPersonVoV2Converter implements Converter<PersonFactV2, PersonVoV2> {

	@Override
	public PersonVoV2 convert(PersonFactV2 personFact) {

		PersonVoV2 personVoV2 = new PersonVoV2();
		personVoV2.setName(personFact.getName());
		personVoV2.setAge(personFact.getAge());
		personVoV2.setCpf(personFact.getCpf());

		if (!CollectionUtils.isEmpty(personFact.getAddresses())) {
			personVoV2.setAddresses(personFact.getAddresses());
		}

		return personVoV2;
	}
}
