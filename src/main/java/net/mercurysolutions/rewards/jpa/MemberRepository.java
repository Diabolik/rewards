/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.jpa;

import java.util.List;

import net.mercurysolutions.rewards.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

	public Member findByEmail(String email);

	public Member findByNickname(String nickname);
	
	public List<Member> findAllByEmailAndPassword(String email, String password);
	
	public List<Member> findAllByNicknameAndPassword(String nickname, String password);
}
