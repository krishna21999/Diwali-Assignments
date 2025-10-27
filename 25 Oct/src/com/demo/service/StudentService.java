
package com.demo.service;

import com.demo.beans.Student;
import com.demo.Exception.InsufficientAttendanceException;
import com.demo.dao.StudentDAO;
import java.util.*;

public class StudentService {
    
    private StudentDAO studentDAO;
    private static final String DEFAULT_FILENAME = "students.ser";
    
    public StudentService() {
        this.studentDAO = new StudentDAO();
    }
    
  
    public List<Student> createSampleStudents() {
        List<Student> students = new ArrayList<>();
        
        try {
            students.add(new Student(101, "Rahul Sharma", "Java", 85.5, 78.0));
            students.add(new Student(102, "Priya Patel", "Python", 92.0, 88.5));
            students.add(new Student(103, "Amit Kumar", "C++", 78.3, 65.0));
            students.add(new Student(104, "Sneha Gupta", "Java", 95.7, 91.2));
            students.add(new Student(105, "Vikas Singh", "React", 88.9, 82.3));
            students.add(new Student(106, "Neha Reddy", "Python", 67.4, 70.5));
            students.add(new Student(107, "Ravi Verma", "Java", 81.2, 76.8));
            students.add(new Student(108, "Pooja Joshi", "C++", 90.5, 85.0));
            students.add(new Student(109, "Karan Mehta", "React", 73.6, 68.9));
            students.add(new Student(110, "Anjali Desai", "Python", 96.8, 93.5));
            
            System.out.println("✓ Created 10 sample students successfully!");
            
        } catch (InsufficientAttendanceException e) {
            System.err.println("⚠ Error creating student: " + e.getMessage());
        }
        
        return students;
    }
    
  
    public TreeSet<Student> sortStudentsByAttendance(List<Student> students) {
        return new TreeSet<>(students);
    }
    
  
    public double calculateAverageAttendance(Collection<Student> students) {
        if (students.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Student student : students) {
            total += student.getAttendance_percentage();
        }
        return total / students.size();
    }
    
   
    public double calculateAverageScore(Collection<Student> students) {
        if (students.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Student student : students) {
            total += student.getScore();
        }
        return total / students.size();
    }
    
   
    public Map<String, Long> getGradeDistribution(Collection<Student> students) {
        Map<String, Long> distribution = new TreeMap<>();
        for (Student student : students) {
            String grade = student.calculateGrade();
            distribution.put(grade, distribution.getOrDefault(grade, 0L) + 1);
        }
        return distribution;
    }
    
  
    public boolean saveStudents(List<Student> students) {
        return studentDAO.saveStudentsToFile(students, DEFAULT_FILENAME);
    }
    
    
    public boolean saveStudents(List<Student> students, String filename) {
        return studentDAO.saveStudentsToFile(students, filename);
    }
    
 
    public List<Student> loadStudents() {
        return studentDAO.loadStudentsFromFile(DEFAULT_FILENAME);
    }
    
  
    public List<Student> loadStudents(String filename) {
        return studentDAO.loadStudentsFromFile(filename);
    }
    
  
    public Student findStudentByRollNo(List<Student> students, int rollno) {
        return studentDAO.findStudentByRollNo(students, rollno);
    }
    
 
    public List<Student> findStudentsByCourse(List<Student> students, String course) {
        return studentDAO.findStudentsByCourse(students, course);
    }
    
   
    public void displayStudents(Collection<Student> students) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("STUDENT LIST");
        System.out.println("=".repeat(100));
        
        int count = 1;
        for (Student student : students) {
            System.out.printf("%2d. %s%n", count++, student);
        }
        System.out.println("=".repeat(100));
    }
    

    public void displayStatistics(Collection<Student> students) {
        System.out.println("\n--- STATISTICS ---");
        System.out.printf("Total Students: %d%n", students.size());
        System.out.printf("Average Attendance: %.2f%%%n", calculateAverageAttendance(students));
        System.out.printf("Average Score: %.2f%n", calculateAverageScore(students));
        
        System.out.println("\n--- GRADE DISTRIBUTION ---");
        Map<String, Long> gradeDistribution = getGradeDistribution(students);
        gradeDistribution.forEach((grade, count) -> 
            System.out.printf("Grade %s: %d student(s)%n", grade, count)
        );
    }
    

    public void testAttendanceException() {
        System.out.println("\n--- TESTING ATTENDANCE EXCEPTION ---");
        try {
            Student invalidStudent = new Student(999, "Test Student", "Java", 45.0, 75.0);
        } catch (InsufficientAttendanceException e) {
            System.err.println("⚠ Exception caught: " + e.getMessage());
        }
    }
}
