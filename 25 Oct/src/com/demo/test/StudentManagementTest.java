
package com.demo.test;

import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.Exception.InsufficientAttendanceException;
import java.util.*;

public class StudentManagementTest {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║       STUDENT MANAGEMENT SYSTEM - TESTING MODULE          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        
       
        StudentService studentService = new StudentService();
        
       
        System.out.println("\n[TEST 1] Creating 10 Sample Students");
        System.out.println("-".repeat(60));
        List<Student> studentList = studentService.createSampleStudents();
        
        
        studentService.testAttendanceException();
        
      
        System.out.println("\n[TEST 3] Serializing Students to File");
        System.out.println("-".repeat(60));
        boolean saved = studentService.saveStudents(studentList);
        
        if (saved) {
           
            System.out.println("\n[TEST 4] Deserializing Students from File");
            System.out.println("-".repeat(60));
            List<Student> loadedStudents = studentService.loadStudents();
            
           
            System.out.println("\n[TEST 5] Sorting Students by Attendance (Decreasing Order)");
            System.out.println("-".repeat(60));
            TreeSet<Student> sortedStudents = studentService.sortStudentsByAttendance(loadedStudents);
            
           
            studentService.displayStudents(sortedStudents);
            
           
            System.out.println("\n[TEST 6] Calculating Statistics");
            System.out.println("-".repeat(60));
            studentService.displayStatistics(sortedStudents);
            
            
            System.out.println("\n[TEST 7] Searching Student by Roll Number");
            System.out.println("-".repeat(60));
            Student foundStudent = studentService.findStudentByRollNo(loadedStudents, 105);
            if (foundStudent != null) {
                System.out.println("✓ Found: " + foundStudent);
            } else {
                System.out.println("✗ Student not found!");
            }
            
            
            System.out.println("\n[TEST 8] Searching Students by Course (Java)");
            System.out.println("-".repeat(60));
            List<Student> javaStudents = studentService.findStudentsByCourse(loadedStudents, "Java");
            System.out.println("✓ Found " + javaStudents.size() + " Java students:");
            for (Student s : javaStudents) {
                System.out.println("   • " + s);
            }
            
          
            System.out.println("\n[TEST 9] Course-wise Student Count");
            System.out.println("-".repeat(60));
            Map<String, Integer> courseCount = new TreeMap<>();
            for (Student s : loadedStudents) {
                courseCount.put(s.getCourse(), 
                    courseCount.getOrDefault(s.getCourse(), 0) + 1);
            }
            courseCount.forEach((course, count) -> 
                System.out.printf("%-10s: %d student(s)%n", course, count)
            );
            
           
            System.out.println("\n[TEST 10] Top 3 Students by Attendance");
            System.out.println("-".repeat(60));
            Iterator<Student> iterator = sortedStudents.iterator();
            int rank = 1;
            while (iterator.hasNext() && rank <= 3) {
                Student s = iterator.next();
                System.out.printf("🏆 Rank %d: %s%n", rank++, s);
            }
        }
        
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              ALL TESTS COMPLETED SUCCESSFULLY              ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}
