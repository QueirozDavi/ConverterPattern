package com.poc.converters.converters.output;

import static com.poc.converters.util.PersonUtils.getAddressVoFromAddressFact;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.poc.converters.model.v1.fact.PersonFact;
import com.poc.converters.model.v1.vo.PersonVo;

@Component
public class PersonFactToPersonVoConverter implements Converter<PersonFact, PersonVo> {

	@Override
	public PersonVo convert(PersonFact personFact) {
		PersonVo personVo = new PersonVo();
		personVo.setAge(personFact.getAge());
		personVo.setName(personFact.getName());
		personVo.setCpf(personFact.getCpf());

		if (!CollectionUtils.isEmpty(personFact.getAddresses())) {
			personVo.setAddresses(new ArrayList<>());
			personFact.getAddresses().forEach(address -> personVo.getAddresses().add(getAddressVoFromAddressFact(address)));
		}

		return personVo;
	}
}
