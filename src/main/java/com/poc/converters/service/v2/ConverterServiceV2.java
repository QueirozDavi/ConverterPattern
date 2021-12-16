package com.poc.converters.service.v2;

import static com.poc.converters.factory.v2.PersonFactFactoryV2.getComplePersonFactV2;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.converters.converters.v2.PersonConverterV2;
import com.poc.converters.model.dto.PersonRequestDTO;
import com.poc.converters.model.v1.vo.PersonVo;
import com.poc.converters.model.v2.vo.PersonVoV2;

@Service
public class ConverterServiceV2 {

	private final ModelMapper mapper;
	private final PersonConverterV2 converter;

	@Autowired
	public ConverterServiceV2(ModelMapper mapper, PersonConverterV2 converter) {

		this.mapper = mapper;
		this.converter = converter;
	}

	public List<PersonVoV2> convertToPersonVoUsingModelMapper(List<PersonRequestDTO> persons) {

		List<PersonVoV2> personVos = new ArrayList<>();

		persons.forEach(personVoV2 ->
				personVos.add(mapper.map(getComplePersonFactV2(personVoV2.getName(), personVoV2.getAge(), personVoV2.getCpf()), PersonVoV2.class))
		);

		return personVos;
	}

	public List<PersonVoV2> convertToPersonVoUsingConversionService(List<PersonRequestDTO> persons) {

		List<PersonVoV2> personVos = new ArrayList<>();

		persons.forEach(personVo ->
				personVos.add(converter.getPersonVoV2(getComplePersonFactV2(personVo.getName(), personVo.getAge(), personVo.getCpf()))
		));

		return personVos;
	}

}
