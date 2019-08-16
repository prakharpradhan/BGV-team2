package com.cg.backgroundverification.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;

public interface EmployeeService {

	void storeDocument(MultipartFile file) throws BackgroundVerificationException;

	String storeFileDetails(EmployeeDocumentDTO employeeDocumentDTO) throws BackgroundVerificationException;

	List<String> viewStatus(int empId);

}
