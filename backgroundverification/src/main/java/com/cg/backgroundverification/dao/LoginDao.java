package com.cg.backgroundverification.dao;

import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;

public interface LoginDao {
	LoginDto login(LoginDto loginDto) throws BackgroundVerificationException;
}
