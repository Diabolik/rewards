/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package net.mercurysolutions.rewards.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import net.mercurysolutions.rewards.domain.Member;
import net.mercurysolutions.rewards.entity.MemberEntity;
import net.mercurysolutions.rewards.exception.EventsErrorCode;
import net.mercurysolutions.rewards.services.MemberService;

@RestController
@RequestMapping("/api")
@Api(description = "User Model API", value = "")
public class MemberController {

	private final static Log log = LogFactory.getLog(MemberController.class);

	@Autowired
	private MemberService userService;
	
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	@ApiOperation(value = "User login in sByMe", notes = "User login in sByMe")
	public ResponseEntity<MemberEntity> loginUser(@RequestBody MemberEntity user) {
		String login = user.getEmail();
		String password = user.getPassword();
		
		ResponseEntity<MemberEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		
		//Search the user by email
		List<Member> users = userService.findAllByEmailAndPassword(login, password);
		
		if(users.isEmpty()) {
			//Search the user by nickname
			login = user.getNickname();
			users = userService.findByNicknameAndPassword(login, password);
			if(users.isEmpty()) {
				EventsErrorCode managedError = EventsErrorCode.USER_NOT_FOUND;
				log.error(managedError);
				responseHeaders.add("ERROR", managedError.toString());
				return new ResponseEntity<MemberEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
			}
		}
		
		MemberEntity entity = (MemberEntity) users.get(0).toEntity();
		response = new ResponseEntity<MemberEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ApiOperation(value = "Save the user provided", notes = "Save the user provided")
	public ResponseEntity<MemberEntity> save(@RequestBody MemberEntity entity) {
		ResponseEntity<MemberEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();

		emailExists(entity.getEmail(), responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<MemberEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		nicknameExists(entity.getNickname(), responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<MemberEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		Member user = (Member) entity.toModel();
		//Filling default data.
		user.initBasicUser();
		
		//Saving and converting user
		entity = (MemberEntity) userService.save(user).toEntity();

		response = new ResponseEntity<MemberEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	
	/**
	 * Verify if the email is used
	 * 
	 * @param email
	 * @param headers
	 */
	private void emailExists(String email, HttpHeaders headers) {
		if (userService.findByEmail(email) != null) {
			EventsErrorCode managedError = EventsErrorCode.USER_FOUND_EMAIL;
			log.error(managedError);
			headers.add("ERROR", managedError.toString());
		}
	}

	/**
	 * Verify if the nickname is used
	 * 
	 * @param nickname
	 * @param headers
	 */
	private void nicknameExists(String nickname, HttpHeaders headers) {
		if (userService.findByNickname(nickname) != null) {
			EventsErrorCode managedError = EventsErrorCode.USER_FOUND_NICKNAME;
			log.error(managedError);
			headers.add("ERROR", managedError.toString());
		}
	}

}