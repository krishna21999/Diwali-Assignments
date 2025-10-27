package com.demo.beans;

public class Employee {

	private String name;
	private int id;
	private String EmpRole;
	public Employee() {
		super();
	}
	public Employee(int id, String name,  String empRole) {
		super();
		this.name = name;
		this.id = id;
		EmpRole = empRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpRole() {
		return EmpRole;
	}
	public void setEmpRole(String empRole) {
		EmpRole = empRole;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", EmpRole=" + EmpRole + "]";
	}
	
	
}
