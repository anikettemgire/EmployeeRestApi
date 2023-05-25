package com.ani.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.dao.EmployeeRepositry;
import com.ani.modal.Employee;
@Component
public class EmployeeSerice {
	
	
	
	@Autowired
	private EmployeeRepositry employeeRepositry;
	
	public Employee saveEmployee(Employee employee) {
		
		Employee employee2 = this.employeeRepositry.save(employee);
		
		return employee2;
		
	}
	
	public List<Employee> getAllEmployeeRecord() {
		List<Employee> findAll = this.employeeRepositry.findAll();
		
		return findAll;
	}
	
	public Employee getRecordById(int id) {
		Optional<Employee> findById = this.employeeRepositry.findById(id);
		return findById.get();
		
		
	}
	
	public List<Employee> getRecordBySalary(int salary) {
		
		   return this.employeeRepositry.findBySalaryGreaterThan(salary);
	}
	
	
	public List<Employee> getByTheExperice(int a,int b) {
		  return this.employeeRepositry.findByExperBetween(a, b);
	}

	public List<Employee> getProfile(String p) {
		
		return this.employeeRepositry.findByProfile(p);
	}
	
	public List<Employee> getProfileNot(String p){
		
		return this.employeeRepositry.findByProfileNot(p);
		
		
	}
	
	public void deteById(int id) {
		this.employeeRepositry.deleteById(id);
	}
}
