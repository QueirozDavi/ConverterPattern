package com.poc.converters.model.v1.fact;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonFact {

	@NotNull
	private String name;
	@NotNull
	private int age;
	@NotNull
	private String cpf;
	private List<AddressFact> addresses;

}
