package com.ani.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ani.modal.Employee;
@Component
public interface EmployeeRepositry extends  JpaRepository<Employee,Integer>{


    public List<Employee>findBySalaryGreaterThan(int salary);
    
    public List<Employee>findByExperBetween(int a,int b);
  
    
    public List<Employee> findByProfile(String p);
    
    public List<Employee> findByProfileNot(String p);
   
}
