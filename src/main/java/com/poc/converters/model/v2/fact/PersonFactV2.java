package com.poc.converters.model.v2.fact;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.poc.converters.model.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonFactV2 {

	@NotNull
	private String name;
	@NotNull
	private int age;
	@NotNull
	private String cpf;
	private List<Address> addresses;

}
