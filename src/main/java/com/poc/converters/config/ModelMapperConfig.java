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
import com.poc.converters.model.v2.fact.PersonFactV2;
import com.poc.converters.model.v2.vo.PersonVoV2;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper getModelMapper() {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(convertPersonFactToPersonVo(), PersonFact.class, PersonVo.class);
		modelMapper.addConverter(convertPersonFactV2ToPersonVoV2(), PersonFactV2.class, PersonVoV2.class);

		return modelMapper;
	}

	private Converter<PersonFact, PersonVo> convertPersonFactToPersonVo() {

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

	private Converter<PersonFactV2, PersonVoV2> convertPersonFactV2ToPersonVoV2() {

		return mappingContext -> {
			PersonFactV2 source = mappingContext.getSource();
			PersonVoV2 personVoV2 = new PersonVoV2();
			personVoV2.setName(source.getName());
			personVoV2.setAge(source.getAge());
			personVoV2.setCpf(source.getCpf());

			if (!CollectionUtils.isEmpty(source.getAddresses())) {
				personVoV2.setAddresses(source.getAddresses());
			}

			return personVoV2;
		};
	}

}
