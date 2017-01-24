/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.entity;

import net.mercurysolutions.rewards.domain.Address;
import net.mercurysolutions.rewards.interfaces.IEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressEntity implements IEntity {
	private Long id;
	
	@Override
	public Object toModel() {
		ObjectMapper mapper = new ObjectMapper();
		Address address = mapper.convertValue(this, Address.class);
		return address;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}