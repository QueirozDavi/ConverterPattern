package com.poc.converters.model.v1.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonVo {

	private String name;
	private int age;
	private String cpf;
	private List<AddressVo> addresses;

}
