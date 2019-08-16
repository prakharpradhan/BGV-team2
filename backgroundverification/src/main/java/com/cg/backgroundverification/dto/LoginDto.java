package com.cg.backgroundverification.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for login data
 * 
 * @author Prakhar
 *
 */
@Entity
@Table(name = "login")
public class LoginDto {
	@Id
	@Column(name = "EMPID")
	int empId;
	@Column(name = "PASSWORD")
	String password;
	@Column(name = "ROLEID")
	int roleId;
	@Column(name = "EMPNAME")
	String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "LoginDto [empId=" + empId + ", password=" + password + ", roleId=" + roleId + ", empName=" + empName
				+ "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
