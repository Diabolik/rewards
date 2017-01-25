/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.mercurysolutions.rewards.domain.Business;
import net.mercurysolutions.rewards.jpa.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
		/**
	 * Returns a detached Location. This method is used for update method
	 * 
	 * @param id
	 * @return
	 */
	public Business findLocationDetached(long id) {
		Business location = locationRepository.findOne(id);
		entityManager.detach(location);
		return location;
	}

	/**
	 * Saves an location.
	 * 
	 * @param location
	 *            Location to save
	 * 
	 * @return Saved location
	 */
	public Business save(Business location) {
		Business savedLocation = locationRepository.save(location);
		return savedLocation;
	}
}