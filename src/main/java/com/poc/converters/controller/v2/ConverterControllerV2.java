package com.poc.converters.controller.v2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poc.converters.model.dto.PersonRequestDTO;
import com.poc.converters.model.v1.vo.PersonVo;
import com.poc.converters.model.v2.vo.PersonVoV2;
import com.poc.converters.service.v1.ConverterService;
import com.poc.converters.service.v2.ConverterServiceV2;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Converter API")
@RequestMapping("/v2")
@CrossOrigin(origins = "*")
@Slf4j
public class ConverterControllerV2 {

	private final ConverterServiceV2 converterService;

	@Autowired
	public ConverterControllerV2(ConverterServiceV2 converterService) {

		this.converterService = converterService;
	}

	@PostMapping(path = "/model-mapper")
	@ResponseStatus(HttpStatus.CREATED)
	public List<PersonVoV2> convertPersonFactToPersonVoWithModelMapper(@Valid @RequestBody List<PersonRequestDTO> personRequestDTOS) {

		long start = System.currentTimeMillis();
		List<PersonVoV2> personVos = converterService.convertToPersonVoUsingModelMapper(personRequestDTOS);
		long end = System.currentTimeMillis();
		log.info("Round trip response time = " + (end - start) + " millis");
		return personVos;
	}

	@PostMapping(path = "/conversion-service")
	@ResponseStatus(HttpStatus.CREATED)
	public List<PersonVoV2> convertPersonFactToPersonVoWithConversionService(@Valid @RequestBody List<PersonRequestDTO> personRequestDTOS) {

		long start = System.currentTimeMillis();
		List<PersonVoV2> personVos = converterService.convertToPersonVoUsingConversionService(personRequestDTOS);
		long end = System.currentTimeMillis();
		log.info("Round trip response time = " + (end - start) + " millis");
		return personVos;
	}
}
