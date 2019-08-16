package com.cg.backgroundverification.service;

import java.util.List;

import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;

public interface BgvService {
	List<EmployeeDocumentDTO> getById(int id) throws BackgroundVerificationException;

	List<EmployeeDocumentDTO> getByName(String name) throws BackgroundVerificationException;

	EmployeeDocumentDTO getDocument(int id) throws BackgroundVerificationException;

	void approveStatus(int id) throws BackgroundVerificationException;

	void rejectStatus(int id) throws BackgroundVerificationException;

}
