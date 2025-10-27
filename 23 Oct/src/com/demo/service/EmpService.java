package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmpService {

	boolean Addemp();

	List<Employee> displayAll();

	boolean removeEmp(int id);

	List<Employee> displaySorted();

	Employee findByName(String name);

	void saveToFile();

	

}
