package com.web.model;

import org.springframework.stereotype.Component;

@Component
public class EmpModel {
	private int empId;
	private String empName;
	private int salary;
	private int deptNo;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "EmpModel [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", deptNo=" + deptNo + "]";
	}
	
	
}
