package com.cg.backgroundverification.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.dao.BgvDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.utility.ExceptionMessages;

/**
 * Dao class to interact with database
 * 
 * @author Prakhar
 *
 */
@Repository
@Transactional
public class BgvDaoImpl implements BgvDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * getiing employee details from its id
	 */
	@Override
	public List<EmployeeDocumentDTO> getById(int id) throws BackgroundVerificationException {
		TypedQuery<EmployeeDocumentDTO> query = entityManager
				.createQuery("select emp from EmployeeDocumentDTO emp where emp.empId=:id", EmployeeDocumentDTO.class);
		query.setParameter("id", id);
		List<EmployeeDocumentDTO> documentDTO = new ArrayList<EmployeeDocumentDTO>();

		documentDTO = query.getResultList();

		if (documentDTO.isEmpty()) {
			throw new BackgroundVerificationException(ExceptionMessages.EMP_ID_NOT_FOUND);
		}
		return documentDTO;
	}

	/**
	 * getting emp details by its name
	 */
	@Override
	public List<EmployeeDocumentDTO> getByName(String name) throws BackgroundVerificationException {
		TypedQuery<LoginDto> query = entityManager.createQuery("select emp from LoginDto emp where emp.empName=:name",
				LoginDto.class);
		query.setParameter("name", name);
		LoginDto loginDto = new LoginDto();
		try {
			loginDto = query.getSingleResult();
		} catch (NoResultException e) {
			throw new BackgroundVerificationException(ExceptionMessages.EMP_NOT_FOUND);
		}

		TypedQuery<EmployeeDocumentDTO> query2 = entityManager
				.createQuery("select emp from EmployeeDocumentDTO emp where emp.empId=:id", EmployeeDocumentDTO.class);
		query2.setParameter("id", loginDto.getEmpId());
		List<EmployeeDocumentDTO> documentDTO = new ArrayList<EmployeeDocumentDTO>();

		documentDTO = query2.getResultList();

		if (documentDTO.isEmpty()) {
			throw new BackgroundVerificationException(ExceptionMessages.EMP_ID_NOT_FOUND);
		}
		return documentDTO;
	}

	/**
	 * getting employee details by its id
	 */

	@Override
	public EmployeeDocumentDTO findById(int id) throws BackgroundVerificationException {
		EmployeeDocumentDTO documentDTO = entityManager.find(EmployeeDocumentDTO.class, id);
		if (documentDTO.getVerificationDTO().getStatus().equalsIgnoreCase("approved")
				|| documentDTO.getVerificationDTO().getStatus().equalsIgnoreCase("rejected")) {
			throw new BackgroundVerificationException(ExceptionMessages.CASE_CLOSED);
		}
		return documentDTO;
	}

	/**
	 * approve status update the database
	 */
	@Override
	public void approveStatus(int id) throws BackgroundVerificationException {
		LocalDate now = LocalDate.now();
		EmployeeDocumentDTO documentDTO = entityManager.find(EmployeeDocumentDTO.class, id);
		if (documentDTO.getVerificationDTO().getStatus().equalsIgnoreCase("pending")) {
			documentDTO.getVerificationDTO().setStatus("Approved");
			documentDTO.getVerificationDTO().setRequestEndDate(now);
		} else {
			throw new BackgroundVerificationException(ExceptionMessages.CASE_CLOSED);
		}

	}

	/**
	 * reject status update the database
	 */
	@Override
	public void rejectStatus(int id) throws BackgroundVerificationException {
		LocalDate now = LocalDate.now();

		EmployeeDocumentDTO documentDTO = entityManager.find(EmployeeDocumentDTO.class, id);
		if (documentDTO.getVerificationDTO().getStatus().equalsIgnoreCase("pending")) {
			documentDTO.getVerificationDTO().setStatus("Rejected");
			documentDTO.getVerificationDTO().setRequestEndDate(now);
		} else {
			throw new BackgroundVerificationException(ExceptionMessages.CASE_CLOSED);
		}
	}
}
