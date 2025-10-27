package com.demo.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.demo.beans.Employee;

public class EmpDaoImpl implements EmpDao {

    // In-memory list of employees
    private static List<Employee> lst = new ArrayList<>();

    @Override
    public boolean save(Employee e) {
        return lst.add(e);
    }

    @Override
    public List<Employee> findall() {
        return lst;
    }

    @Override
    public boolean remove(int id) {
        return lst.removeIf(e -> e.getId() == id);
    }

    @Override
    public List<Employee> sort() {
        // Sort by employee name for example
        List<Employee> sortedList = new ArrayList<>(lst);
        Collections.sort(sortedList, Comparator.comparing(Employee::getName));
        return sortedList;
    }

    @Override
    public Employee serchByname(String name) {
        for (Employee e : lst) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

	@Override
	public void saveFile() {
	    try (FileWriter fw = new FileWriter("employees.txt")) {
	        for (Employee e : lst) {
	            fw.write(e.getId() + "," + e.getName() + "," + e.getEmpRole() + "\n");
	        }
	        System.out.println("Employees saved successfully to file.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
