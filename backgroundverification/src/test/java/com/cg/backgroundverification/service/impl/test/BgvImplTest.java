package com.cg.backgroundverification.service.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.service.BgvService;
import com.cg.backgroundverification.service.EmployeeService;
import com.cg.backgroundverification.service.LoginService;

@Configuration
@ComponentScan(basePackages = { "com.cg.backgroundverification.service.impl",
								"com.cg.backgroundverification.dao.impl.test" })
class SpringTestContext {

}

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestContext.class)
public class BgvImplTest {
	@Autowired
	LoginService loginService;

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	BgvService bgvService;
	LoginDto loginDto;
	EmployeeDocumentDTO employeeDocumentDTO;
	
	@Test
	public void loginTest() throws BackgroundVerificationException {
		LoginDto result=loginService.login(loginDto);
		assertEquals(result,result);
	}
	
	@Test
	public void getByIdtest() throws BackgroundVerificationException {
		int id = 0;
		List<EmployeeDocumentDTO> result=bgvService.getById(id);
		assertEquals(null,result);
	}

	@Test
	public void getByNameTest() throws BackgroundVerificationException {
		String name = null;
		List<EmployeeDocumentDTO> result=bgvService.getByName(name);
		assertEquals(null,result);
	}
	
	@Test
	public void findByIdTest() throws BackgroundVerificationException {
		int id = 0;
		EmployeeDocumentDTO result = bgvService.getDocument(id);
		assertEquals(null, result);
	}
	
	@Test
	public void viewStatus() {
		int empId = 0;
		List<String> result = employeeService.viewStatus(empId);
		assertEquals(null, result);
	}

}
