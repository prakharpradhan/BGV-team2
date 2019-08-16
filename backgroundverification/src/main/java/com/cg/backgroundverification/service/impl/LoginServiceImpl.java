package com.cg.backgroundverification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.LoginDao;
import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.service.LoginService;

/**
 * service class
 * 
 * @author trainee
 *
 */

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	/**
	 * service class method for login
	 */

	@Override
	public LoginDto login(LoginDto loginDto) throws BackgroundVerificationException {

		LoginDto dto = new LoginDto();
		dto = loginDao.login(loginDto);
		return dto;
	}

}
