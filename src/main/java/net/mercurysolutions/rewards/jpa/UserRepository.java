/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.jpa;

import java.util.List;

import net.mercurysolutions.rewards.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public User findByNickname(String nickname);
	
	public List<User> findAllByEmailAndPassword(String email, String password);
	
	public List<User> findAllByNicknameAndPassword(String nickname, String password);
}
