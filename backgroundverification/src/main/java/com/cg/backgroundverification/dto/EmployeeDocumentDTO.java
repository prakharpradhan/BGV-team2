package com.cg.backgroundverification.dto;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * dto class for storing document details
 * 
 * @author Vishal
 *
 */
@Entity
@Table(name = "document")
public class EmployeeDocumentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for mysql
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docid")
//	@SequenceGenerator(name = "docid", sequenceName = "docid", allocationSize = 1)
	@Column(name = "docid")
	private int docId;

//    @Column(name="name", length=100, nullable=false)
//    private String documentName;

//    @Column(name="type")
//    private String documentType;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "DOCFILE")
	private byte[] data;

	@Column(name = "DOCTYPEID")
	private int docTypeId;

	@Column(name = "EMPID")
	private int empId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "REQUESTID", referencedColumnName = "REQUESTID")
	private VerificationDTO verificationDTO;

	public VerificationDTO getVerificationDTO() {
		return verificationDTO;
	}

	public void setVerificationDTO(VerificationDTO verificationDTO) {
		this.verificationDTO = verificationDTO;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getDocTypeId() {
		return docTypeId;
	}

	public void setDocTypeId(int docTypeId) {
		this.docTypeId = docTypeId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "EmployeeDocumentDTO [docId=" + docId + ", data=" + Arrays.toString(data) + ", docTypeId=" + docTypeId
				+ ", empId=" + empId + "]";
	}

}
