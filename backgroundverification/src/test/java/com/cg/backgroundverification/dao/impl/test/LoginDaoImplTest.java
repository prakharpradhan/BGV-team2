package com.cg.backgroundverification.dao.impl.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.dao.LoginDao;
import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;

@Repository
public class LoginDaoImplTest implements LoginDao {

	@Override
	public LoginDto login(LoginDto loginDto) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		return null;
	}

}
