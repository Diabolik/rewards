/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import net.mercurysolutions.rewards.domain.Member;
import net.mercurysolutions.rewards.jpa.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberRepository userRepository;
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	/**
	 * Find User by email
	 * 
	 * @param email
	 * @return
	 */
	public Member findByEmail(String email) {
		Member user = userRepository.findByEmail(email);
		return user;
	}
	
	/**
	 * Find User by nickname
	 * 
	 * @param nickname
	 * @return
	 */
	public Member findByNickname(String nickname) {
		Member user = userRepository.findByNickname(nickname);
		return user;
	}
	
	/**
	 * Find User by email and password
	 * 
	 * @param email
	 * @return
	 */
	public List<Member> findAllByEmailAndPassword(String email, String password) {
		List<Member> users = userRepository.findAllByEmailAndPassword(email, password);
		return users;
	}

	/**
	 * Find User by nickname and password
	 * 
	 * @param nickname
	 * @return
	 */
	public List<Member> findByNicknameAndPassword(String nickname, String password) {
		List<Member> users = userRepository.findAllByNicknameAndPassword(nickname, password);
		return users;
	}
	
	/**
	 * Returns a detached User. This method is used for update method
	 * 
	 * @param id
	 * @return
	 */
	public Member findUserDetached(long id) {
		Member user = userRepository.findOne(id);
		entityManager.detach(user);
		return user;
	}
	
	/**
	 * Verify if the user exists in the database
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(Long id) {
    	return userRepository.exists(id);
    }

	/**
	 * Saves an user.
	 * 
	 * @param user
	 *            User to save
	 * 
	 * @return Saved user
	 */
	public Member save(Member user) {
		Member savedUser = userRepository.save(user);
		return savedUser;
	}
}