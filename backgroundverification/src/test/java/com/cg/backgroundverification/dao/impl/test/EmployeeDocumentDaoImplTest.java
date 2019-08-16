package com.cg.backgroundverification.dao.impl.test;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.backgroundverification.dao.EmployeeDocumentDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
@Component
public class EmployeeDocumentDaoImplTest implements EmployeeDocumentDao {

	@Override
	public String uploadDocument(EmployeeDocumentDTO employeeDocumentDTO) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> viewStatus(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
