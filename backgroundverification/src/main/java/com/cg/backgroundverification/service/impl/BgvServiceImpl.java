package com.cg.backgroundverification.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backgroundverification.dao.BgvDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.service.BgvService;

/**
 * service Class for bgv team service
 * 
 * @author team 2
 *
 */
@Service
public class BgvServiceImpl implements BgvService {

	@Autowired
	private BgvDao bgvDao;

	/**
	 * view emp by Id
	 */
	@Override
	public List<EmployeeDocumentDTO> getById(int id) throws BackgroundVerificationException {
		return bgvDao.getById(id);

	}

	/**
	 * view emp by name
	 */
	@Override
	public List<EmployeeDocumentDTO> getByName(String name) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		return bgvDao.getByName(name);
	}

	/**
	 * getting document details
	 */
	public EmployeeDocumentDTO getDocument(int id) throws BackgroundVerificationException {
		return bgvDao.findById(id);
		// .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +
		// fileId));
	}

	/**
	 * setting status to appprove
	 */
	@Override
	public void approveStatus(int id) throws BackgroundVerificationException {
		bgvDao.approveStatus(id);

	}

	/**
	 * setting status to reject
	 */

	@Override
	public void rejectStatus(int id) throws BackgroundVerificationException {
		bgvDao.rejectStatus(id);

	}

}
