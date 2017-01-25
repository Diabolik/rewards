/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.jpa;

import net.mercurysolutions.rewards.domain.Business;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Business, Long> {
}
