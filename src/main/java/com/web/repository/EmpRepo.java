package com.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.web.model.EmpModel;

@Repository
public class EmpRepo {
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void addEmpRepo(EmpModel emp) {
		String sql = "insert into empJDBC values(?,?,?,?);";
		int data = jdbc.update(sql, emp.getEmpId(), emp.getEmpName(), emp.getSalary(), emp.getDeptNo());
		System.out.printf("%d reocrds inserted!\n", data);
	}
	
	public void updateSalaryByEmpIdRepo(EmpModel emp) {
		String sql = "update empJDBC set salary=? where empId=?;";
		int data = jdbc.update(sql, emp.getSalary(), emp.getEmpId());
		System.out.printf("%d reocrds inserted!\n", data);
	}
	
	public List<EmpModel> getEmpRepo() {
		String sql = "select * from empJDBC;";
		RowMapper<EmpModel> mapper = new RowMapper<EmpModel>() {
			@Override
			public EmpModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpModel emp = new EmpModel();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpName(rs.getString("empName"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDeptNo(rs.getInt("deptNo"));
				return emp;
			}
		};
		return jdbc.query(sql, mapper);
	}
}
