package com.poc.converters.controller.v1;

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
import com.poc.converters.service.v1.ConverterService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Converter API")
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
@Slf4j
public class ConverterController {

	private final ConverterService converterService;

	@Autowired
	public ConverterController(ConverterService converterService) {

		this.converterService = converterService;
	}

	@PostMapping(path = "/model-mapper")
	@ResponseStatus(HttpStatus.CREATED)
	public String convertPersonFactToPersonVoWithModelMapper(@Valid @RequestBody List<PersonRequestDTO> personRequestDTOS) {

		long start = System.currentTimeMillis();
		converterService.convertToPersonVoUsingModelMapper(personRequestDTOS);
		long end = System.currentTimeMillis();
		return "Round trip response time = " + (end - start) + " millis";
	}

	@PostMapping(path = "/conversion-service")
	@ResponseStatus(HttpStatus.CREATED)
	public String convertPersonFactToPersonVoWithConversionService(@Valid @RequestBody List<PersonRequestDTO> personRequestDTOS) {

		long start = System.currentTimeMillis();
		converterService.convertToPersonVoUsingConversionService(personRequestDTOS);
		long end = System.currentTimeMillis();
		return "Round trip response time = " + (end - start) + " millis";
	}
}
