package com.poc.converters.config;

import java.util.ArrayList;
import java.util.Objects;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import com.poc.converters.model.v1.fact.AddressFact;
import com.poc.converters.model.v1.fact.PersonFact;
import com.poc.converters.model.v1.vo.AddressVo;
import com.poc.converters.model.v1.vo.PersonVo;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper getModelMapper() {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(convertPersonToPersonFact(), PersonFact.class, PersonVo.class);

		return modelMapper;
	}

	private Converter<PersonFact, PersonVo> convertPersonToPersonFact() {

		return mappingContext -> {
			PersonFact source = mappingContext.getSource();
			PersonVo personVo = new PersonVo();
			personVo.setAge(source.getAge());
			personVo.setName(source.getName());
			personVo.setCpf(source.getCpf());

			if (!CollectionUtils.isEmpty(source.getAddresses())) {
				personVo.setAddresses(new ArrayList<>());
				source.getAddresses().forEach(address -> personVo.getAddresses().add(getAddressVoFromAddressFact(address)));
			}

			return personVo;
		};
	}

	private AddressVo getAddressVoFromAddressFact(AddressFact address) {

		AddressVo addressVo = new AddressVo();
		addressVo.setNumber(address.getNumber());
		addressVo.setPrimaryAddress(address.isPrimaryAddress());

		if (Objects.nonNull(address.getStreet())) {
			addressVo.setStreet(address.getStreet());
		}

		if (Objects.nonNull(address.getPhoneNumber())) {
			addressVo.setPhoneNumber(address.getPhoneNumber());
		}

		if (Objects.nonNull(address.getComplement())) {
			addressVo.setComplement(address.getComplement());
		}

		if (Objects.nonNull(address.getReference())) {
			addressVo.setReference(address.getReference());
		}

		if (Objects.nonNull(address.getPhoneNumber())) {
			addressVo.setPhoneNumber(address.getPhoneNumber());
		}

		return addressVo;
	}
}
