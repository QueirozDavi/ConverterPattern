package com.poc.converters.util;

import java.util.Objects;

import com.poc.converters.model.Address;
import com.poc.converters.model.v1.fact.AddressFact;
import com.poc.converters.model.v1.vo.AddressVo;

public class PersonUtils {

	private PersonUtils() {
		throw new IllegalStateException("Utility Class");
	}

	public static AddressVo getAddressVoFromAddressFact(AddressFact address) {

		AddressVo addressVo = new AddressVo();
		addressVo.setNumber(address.getNumber());
		addressVo.setPrimaryAddress(address.isPrimaryAddress());

		if (Objects.nonNull(address.getStreet())) {
			addressVo.setStreet(address.getStreet());
		}

		if (Objects.nonNull(address.getPhoneNumber())) {
			addressVo.setPhoneNumber(address.getPhoneNumber());
		}

		if (Objects.nonNull(address.getComplement())) {
			addressVo.setComplement(address.getComplement());
		}

		if (Objects.nonNull(address.getReference())) {
			addressVo.setReference(address.getReference());
		}

		if (Objects.nonNull(address.getPhoneNumber())) {
			addressVo.setPhoneNumber(address.getPhoneNumber());
		}

		return addressVo;
	}

}
