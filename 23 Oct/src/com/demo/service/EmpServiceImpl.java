package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmpDao;
import com.demo.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService {
	
	Scanner sc=new Scanner(System.in);
	EmpDao Odao;
	

	 public EmpServiceImpl() {
		super();
		this.Odao=new EmpDaoImpl();
	}

	 
	
	@Override
	public boolean Addemp() {
	  Scanner sc=new Scanner(System.in);
      System.out.println("Enter the id");
      int id=sc.nextInt();
      
      System.out.println("Enter the name :");
      String name=sc.next();
      
      System.out.println("Enter the role :");
      String role=sc.next();
      
      Employee e= new Employee(id,name,role);
      
      
      
		return Odao.save(e);
	}



	@Override
	public List<Employee> displayAll() {
		
		return 	Odao.findall();
	}



	@Override
	public boolean removeEmp(int id) {
		
		return Odao.remove(id);
	}



	@Override
	public List<Employee> displaySorted() {
		
		return Odao.sort();
	}



	@Override
	public Employee findByName(String name) {
		
		return Odao.serchByname(name);
	}



	@Override
	public void saveToFile() {
		
		Odao.saveFile();
		
	}

	
}
