package com.cg.backgroundverification.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * dto to store all request details
 * 
 * @author Vishal
 *
 */
@Entity
@Table(name = "verificationdetails")
public class VerificationDTO {

	@Id
	@Column(name = "REQUESTID")

	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reqid")
//	@SequenceGenerator(name = "reqid", sequenceName = "reqid", allocationSize = 1)
	private int requestId;

	@Column(name = "REQUESTSTARTDATE")
	private LocalDate requestStartDate;

	@Column(name = "REQUESTENDDATE")
	private LocalDate requestEndDate;

	@Column(name = "STATUS")
	private String status;

	@OneToOne(mappedBy = "verificationDTO")
	private EmployeeDocumentDTO employeeDocumentDTO;

	public VerificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerificationDTO(int requestId, LocalDate requestStartDate, LocalDate requestEndDate, String status) {
		super();
		this.requestId = requestId;
		this.requestStartDate = requestStartDate;
		this.requestEndDate = requestEndDate;
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public LocalDate getRequestStartDate() {
		return requestStartDate;
	}

	public void setRequestStartDate(LocalDate requestStartDate) {
		this.requestStartDate = requestStartDate;
	}

	public LocalDate getRequestEndDate() {
		return requestEndDate;
	}

	public void setRequestEndDate(LocalDate requestEndDate) {
		this.requestEndDate = requestEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VerificationDTO [requestId=" + requestId + ", requestStartDate=" + requestStartDate
				+ ", requestEndDate=" + requestEndDate + ", status=" + status + "]";
	}

}
