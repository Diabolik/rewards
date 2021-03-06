/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.entity;

import java.util.Set;

import net.mercurysolutions.rewards.domain.Business;
import net.mercurysolutions.rewards.interfaces.IEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationEntity implements IEntity{
	private Long id;
	
	private String name;
	
	private String description;
	
	private String place;
	
	private boolean visibility;
	
	private MemberEntity owner;
	
	private AddressEntity address;
	
	private Set<CommentEntity> comments;
	
	private Set<GalleryItemEntity> gallery;
	
	@Override
	public Object toModel() {
		ObjectMapper mapper = new ObjectMapper();
		Business location = mapper.convertValue(this, Business.class);
		return location;
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

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the visibility
	 */
	public boolean isVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the owner
	 */
	public MemberEntity getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(MemberEntity owner) {
		this.owner = owner;
	}
	
	/**
	 * @return the address
	 */
	public AddressEntity getAddress() {
		return address;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	/**
	 * @return the comments
	 */
	public Set<CommentEntity> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}

	/**
	 * @return the gallery
	 */
	public Set<GalleryItemEntity> getGallery() {
		return gallery;
	}

	/**
	 * @param gallery the gallery to set
	 */
	public void setGallery(Set<GalleryItemEntity> gallery) {
		this.gallery = gallery;
	}
}
