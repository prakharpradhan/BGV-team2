/**
 * 
 */
package com.cg.backgroundverification.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.dao.EmployeeDocumentDao;
import com.cg.backgroundverification.dto.EmployeeDocumentDTO;
import com.cg.backgroundverification.exceptions.BackgroundVerificationException;
import com.cg.backgroundverification.utility.ExceptionMessages;

/**
 * dao class to perform employee operation
 * 
 * @author Team 2
 *
 */
@Repository
@Transactional
public class EmployeeDocumentDaoImpl implements EmployeeDocumentDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * upload document method
	 */
	public String uploadDocument(EmployeeDocumentDTO employeeDocumentDTO) throws BackgroundVerificationException {
		TypedQuery<EmployeeDocumentDTO> query = entityManager
				.createQuery("select emp from EmployeeDocumentDTO emp where emp.empId=:id", EmployeeDocumentDTO.class);
		query.setParameter("id", employeeDocumentDTO.getEmpId());
		List<EmployeeDocumentDTO> documentDTO = new ArrayList<EmployeeDocumentDTO>();
		documentDTO = query.getResultList();
		for (EmployeeDocumentDTO document : documentDTO) {
			if (document.getDocTypeId() == employeeDocumentDTO.getDocTypeId()
					&& document.getVerificationDTO().getStatus().equals("pending")) {
				throw new BackgroundVerificationException(ExceptionMessages.DOCUMENTALREADYEXISTS);
			}
			if (document.getVerificationDTO().getStatus().equalsIgnoreCase("approved")) {
				throw new BackgroundVerificationException(ExceptionMessages.ALREADYVERIFIED);
			}
			if (document.getVerificationDTO().getStatus().equalsIgnoreCase("Rejected")) {
				throw new BackgroundVerificationException(ExceptionMessages.ALREADYVERIFIED);
			}
		}
		entityManager.persist(employeeDocumentDTO);
		return "Document uploaded successfully";
	}

	/**
	 * viewing status for uplopaded document
	 */
	@Override
	public List<String> viewStatus(int empId) {
		TypedQuery<EmployeeDocumentDTO> query = entityManager
				.createQuery("select emp from EmployeeDocumentDTO emp where emp.empId=:id", EmployeeDocumentDTO.class);
		query.setParameter("id", empId);
		List<EmployeeDocumentDTO> documentDTO = new ArrayList<EmployeeDocumentDTO>();
		try {
			documentDTO = query.getResultList();
		} catch (NoResultException e) {

		}
		List<String> status = new ArrayList<String>();
		for (EmployeeDocumentDTO document : documentDTO) {
			if (document.getDocTypeId() == 51012) {
				status.add("Education Proof");
			}
			if (document.getDocTypeId() == 42012) {
				status.add("Address Proof");
			}
			status.add(document.getVerificationDTO().getStatus());

		}

		return status;
	}

}
