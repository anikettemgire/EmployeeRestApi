package com.ani.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ani.modal.Employee;
import com.ani.service.EmployeeSerice;

@RestController
public class HomeController {
	@Autowired 
	private EmployeeSerice employeeSerice;
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		try {
		Employee employee2 = this.employeeSerice.saveEmployee(employee);	
		
		return ResponseEntity.of(Optional.of(employee2));
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
	}
	
	@GetMapping("/allRecord")
	public ResponseEntity<List<Employee>> getAllRecord() {
		List<Employee> employeeRecord = this.employeeSerice.getAllEmployeeRecord();
		if(employeeRecord.size()>=0) {
			return ResponseEntity.of(Optional.of(employeeRecord));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/allRecord/{id}")
	public ResponseEntity<Employee> getRecordById(@PathVariable int id) {
		try {
		Employee recordById = this.employeeSerice.getRecordById(id);
		
		return ResponseEntity.of(Optional.of(recordById));
		}catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	
	}
	@GetMapping("/findSalary/{salary}")
	public ResponseEntity<List<Employee>> getRecordBySalary(@PathVariable("salary") int Salary) {
		
		List<Employee> recordBySalary = this.employeeSerice.getRecordBySalary(Salary);
		if(recordBySalary!=null) {
			return ResponseEntity.of(Optional.of(recordBySalary));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/allRecord/{fi}/{si}")
	public ResponseEntity<Object> findByTheExperince(@PathVariable("fi") int fa,@PathVariable("si") int sa) {
		
		List<Employee> byTheExperice = this.employeeSerice.getByTheExperice(fa, sa);
		if(byTheExperice!=null) {
			return ResponseEntity.of(Optional.of(byTheExperice));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@GetMapping("/Profile/{profile}")
	public ResponseEntity<Object> findProfuile(@PathVariable("profile")String profile) {
		
		List<Employee> byTheExperice = this.employeeSerice.getProfile(profile);
		if(byTheExperice!=null) {
			return ResponseEntity.of(Optional.of(byTheExperice));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/profile/{profile}")
	public ResponseEntity<Object> getNotIn(@PathVariable("profile")String profile) {
		
		List<Employee> profileNot = this.employeeSerice.getProfileNot(profile);
		if(profileNot!=null) {
		return ResponseEntity.of(Optional.of(profileNot));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable("id") int id) {
		
		this.employeeSerice.deteById(id);
	}

}
