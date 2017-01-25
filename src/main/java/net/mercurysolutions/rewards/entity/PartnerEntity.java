/*
 * *******************************************************************************
 *   Copyright 2017 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.mercurysolutions.rewards.domain.Partner;
import net.mercurysolutions.rewards.interfaces.IEntity;

public class PartnerEntity implements IEntity {
	private Long id;

	private String name;

	private String email;
	
	private String password;
	
	private String image;
	
	@Override
	public Object toModel() {
		ObjectMapper mapper = new ObjectMapper();
		Partner partner = mapper.convertValue(this, Partner.class);
		return partner;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
}