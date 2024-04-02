package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.EmpModel;
import com.web.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo repo;
	
	public void addEmpService(EmpModel emp) {
		System.out.println("addEmpService...");
		repo.addEmpRepo(emp);
	}
	
	public void updateSalaryByEmpIdService(EmpModel emp) {
		System.out.println("updateEmpService...");
		repo.updateSalaryByEmpIdRepo(emp);
	}
	
	public List<EmpModel> getEmpService() {
		return repo.getEmpRepo();
	}
}
