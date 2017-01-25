/*
 * *******************************************************************************
 *   Copyright 2017 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.domain;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.mercurysolutions.rewards.entity.MemberEntity;
import net.mercurysolutions.rewards.interfaces.IModel;

@JsonIgnoreProperties(ignoreUnknown=true)
@SuppressWarnings("serial")
@Entity
public class Member extends BaseObject implements IModel {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String nip;
	
	@Column (nullable = false)
	private int points;
	
	@Column(nullable = false)
	private String image;

	@Column(nullable = false)
	private Date birthday;
	
	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private UUID cardNumberId;

	@Override
	public Object toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MemberEntity entity = mapper.convertValue(this, MemberEntity.class);
		return entity;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the nip
	 */
	public String getNip() {
		return nip;
	}

	/**
	 * @param nip the nip to set
	 */
	public void setNip(String nip) {
		this.nip = nip;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
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

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the cardNumberId
	 */
	public UUID getCardNumberId() {
		return cardNumberId;
	}

	/**
	 * @param cardNumberId the cardNumberId to set
	 */
	public void setCardNumberId(UUID cardNumberId) {
		this.cardNumberId = cardNumberId;
	}
}