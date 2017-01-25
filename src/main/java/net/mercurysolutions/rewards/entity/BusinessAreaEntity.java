/*
 * *******************************************************************************
 *   Copyright 2017 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.mercurysolutions.rewards.domain.BusinessArea;
import net.mercurysolutions.rewards.interfaces.IEntity;

public class BusinessAreaEntity implements IEntity {
	private Long id;

	private String name;

	private String description;
	
	@Override
	public Object toModel() {
		ObjectMapper mapper = new ObjectMapper();
		BusinessArea category = mapper.convertValue(this, BusinessArea.class);
		return category;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}