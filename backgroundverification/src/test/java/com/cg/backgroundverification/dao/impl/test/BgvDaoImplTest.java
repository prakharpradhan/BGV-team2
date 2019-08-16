package com.cg.backgroundverification.dao.impl.test;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.backgroundverification.dao.BgvDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
@Component
public class BgvDaoImplTest implements BgvDao{

	@Override
	public List<EmployeeDocumentDTO> getById(int id) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDocumentDTO> getByName(String name) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDocumentDTO findById(int id) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveStatus(int id) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectStatus(int id) throws BackgroundVerificationException {
		// TODO Auto-generated method stub
		
	}

}
