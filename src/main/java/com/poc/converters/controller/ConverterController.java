package com.poc.converters.controller;

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

@RestController
@Api(tags = "Converter API")
@RequestMapping("/v1/converter")
@CrossOrigin(origins = "*")
public class ConverterController {

	private final ConverterService converterService;

	@Autowired
	public ConverterController(ConverterService converterService) {

		this.converterService = converterService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<PersonVo> convertPersonFactToPersonVo(@Valid @RequestBody List<PersonRequestDTO> personRequestDTOS) {
		return converterService.convertToPersonVo(personRequestDTOS);
	}
}
