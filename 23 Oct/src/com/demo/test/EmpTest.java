package com.demo.test;

import java.util.List;
import java.util.Scanner;
import com.demo.beans.Employee;
import com.demo.service.*;

public class EmpTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpService eserv = new EmpServiceImpl();
        int choice;

        do {
            System.out.println("\n==== Employee Management System ====");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Show all Employees");
            System.out.println("4. Show all Employees in sorted order");
            System.out.println("5. Find Employee by name");
            System.out.println("6. Save Employees to file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    boolean status = eserv.Addemp();
                    if (status) {
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Failed to add employee.");
                    }
                }

                case 2 -> {
                    System.out.print("Enter employee ID to remove: ");
                    int id = sc.nextInt();
                    boolean removed = eserv.removeEmp(id);
                    if (removed) {
                        System.out.println("Employee removed successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                }

                case 3 -> {
                    List<Employee> empList = eserv.displayAll();
                    empList.forEach(System.out::println);
                }

                case 4 -> {
                    List<Employee> sortedList = eserv.displaySorted();
                    sortedList.forEach(System.out::println);
                }

                case 5 -> {
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    Employee emp = eserv.findByName(name);
                    if (emp != null) {
                        System.out.println(emp);
                    } else {
                        System.out.println("No employee found with that name.");
                    }
                }

                case 6 -> {
                    eserv.saveToFile();
                    System.out.println("Employees saved to file.");
                }

                case 7 -> System.out.println("Exiting program. Goodbye!");

                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
