package com.cg.backgroundverification.dao;

import java.util.List;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;

public interface EmployeeDocumentDao {

	String uploadDocument(EmployeeDocumentDTO employeeDocumentDTO) throws BackgroundVerificationException;

	List<String> viewStatus(int empId);

}