package com.cg.backgroundverification.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cg.backgroundverification.dao.EmployeeDocumentDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.service.EmployeeService;

/**
 * service class to perform employee method
 * 
 * @author team 2
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDocumentDao employeeDocumentDao;
	EmployeeDocumentDTO employeeDocumentDTO = new EmployeeDocumentDTO();

	/**
	 * storing file
	 */

	public void storeDocument(MultipartFile file) throws BackgroundVerificationException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {

			employeeDocumentDTO.setData(file.getBytes());

		} catch (IOException ex) {
			throw new BackgroundVerificationException("Could not store file " + fileName + ". Please try again!");
		}
	}

	/**
	 * storing file info
	 */

	@Override
	public String storeFileDetails(EmployeeDocumentDTO employeeDocument) throws BackgroundVerificationException {

		employeeDocument.setData(employeeDocumentDTO.getData());
		return employeeDocumentDao.uploadDocument(employeeDocument);

	}

	/**
	 * view status
	 */

	@Override
	public List<String> viewStatus(int empId) {

		return employeeDocumentDao.viewStatus(empId);
	}

}
