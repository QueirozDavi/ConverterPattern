package com.poc.converters.factory.v2;

import java.util.List;

import com.poc.converters.model.Address;
import com.poc.converters.model.v2.fact.PersonFactV2;

public class PersonFactFactoryV2 {

	private static final String COMPLEMENT = "5th District";
	private static final String REFERENCE = "Next to the Bus Station";

	public static PersonFactV2 getComplePersonFactV2(final String name, final int age, final String cpf) {

		return new PersonFactV2(name, age, cpf, getAddresses());
	}

	public static List<Address> getAddresses() {

		Address address = new Address("Street 1", "20", 53090678, true, COMPLEMENT, REFERENCE, "+55(11)96745-3443");
		Address address2 = new Address("Street 2", "30", 53090679, false, COMPLEMENT, REFERENCE, "+55(11)96745-9098");
		Address address3 = new Address("Street 3", "40", 53090680, false, COMPLEMENT, REFERENCE, "+55(11)96745-0000");

		return List.of(address, address2, address3);
	}
}
