package com.poc.converters.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String street;
	private String number;
	private int postCode;
	private boolean isPrimaryAddress;
	private String complement;
	private String reference;
	private String phoneNumber;

}
