package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmpDao {

	boolean save(Employee e);

	List<Employee> findall();

	boolean remove(int id);

	List<Employee> sort();

	Employee serchByname(String name);

	void saveFile();

}
