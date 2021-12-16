package com.poc.converters.factory.v1;

import java.util.List;

import com.poc.converters.model.v1.fact.AddressFact;
import com.poc.converters.model.v1.fact.PersonFact;

public class PersonFactFactory {

	private static final String COMPLEMENT = "5th District";
	private static final String REFERENCE = "Next to the Bus Station";

	public static PersonFact getComplePersonFact(final String name, final int age, final String cpf) {

		return new PersonFact(name, age, cpf, getAddresses());
	}

	public static List<AddressFact> getAddresses() {

		AddressFact addressFact = new AddressFact("Street 1", "20", 53090678, true, COMPLEMENT, REFERENCE, "+55(11)96745-3443");
		AddressFact addressFact2 = new AddressFact("Street 2", "30", 53090679, false, COMPLEMENT, REFERENCE, "+55(11)96745-9098");
		AddressFact addressFact3 = new AddressFact("Street 3", "40", 53090680, false, COMPLEMENT, REFERENCE, "+55(11)96745-0000");

		return List.of(addressFact, addressFact2, addressFact3);
	}
}
