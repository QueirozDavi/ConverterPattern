package com.poc.converters.config;

import static com.poc.converters.util.PersonUtils.getAddressVoFromAddressFact;

import java.util.ArrayList;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import com.poc.converters.model.v1.fact.PersonFact;
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

}
