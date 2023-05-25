package com.ani.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffid;
	private String name;
	private String profile;
	private int salary;
	private int exper;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getExper() {
		return exper;
	}
	public void setExper(int exper) {
		this.exper = exper;
	}
	@Override
	public String toString() {
		return "Employee [staffid=" + staffid + ", name=" + name + ", profile=" + profile + ", salary=" + salary
				+ ", exper=" + exper + "]";
	}
	
	
}
