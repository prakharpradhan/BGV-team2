package com.cg.backgroundverification.service;

import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;

public interface LoginService {
	LoginDto login(LoginDto loginDto) throws BackgroundVerificationException;
}
