package com.poc.converters.service.v1;

import static com.poc.converters.factory.PersonFactFactory.getComplePersonFact;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.converters.converters.PersonConverter;
import com.poc.converters.model.dto.PersonRequestDTO;
import com.poc.converters.model.v1.vo.PersonVo;

@Service
public class ConverterService {

	private final ModelMapper mapper;
	private final PersonConverter converter;

	@Autowired
	public ConverterService(ModelMapper mapper, PersonConverter converter) {

		this.mapper = mapper;
		this.converter = converter;
	}

	public List<PersonVo> convertToPersonVoUsingModelMapper(List<PersonRequestDTO> persons) {

		List<PersonVo> personVos = new ArrayList<>();

		persons.forEach(personVo ->
				personVos.add(mapper.map(getComplePersonFact(personVo.getName(), personVo.getAge(), personVo.getCpf()), PersonVo.class))
		);

		return personVos;
	}

	public List<PersonVo> convertToPersonVoUsingConversionService(List<PersonRequestDTO> persons) {

		List<PersonVo> personVos = new ArrayList<>();

		persons.forEach(personVo ->
				personVos.add(converter.getPersonVo(getComplePersonFact(personVo.getName(), personVo.getAge(), personVo.getCpf()))
		));

		return personVos;
	}

}
