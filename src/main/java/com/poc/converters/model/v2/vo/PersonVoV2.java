package com.poc.converters.model.v2.vo;

import java.util.List;

import com.poc.converters.model.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonVoV2 {

	private String name;
	private int age;
	private String cpf;
	private List<Address> addresses;

}
