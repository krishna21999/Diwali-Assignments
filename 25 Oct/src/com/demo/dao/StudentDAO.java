package com.demo.dao;

import com.demo.beans.Student;
import java.io.*;
import java.util.*;

public class StudentDAO {
    
  
    public boolean saveStudentsToFile(List<Student> students, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("✓ Successfully saved " + students.size() + 
                             " students to " + filename);
            return true;
        } catch (IOException e) {
            System.err.println("✗ Error saving students: " + e.getMessage());
            return false;
        }
    }
    
   
    @SuppressWarnings("unchecked")
    public List<Student> loadStudentsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            List<Student> students = (List<Student>) ois.readObject();
            System.out.println("✓ Successfully loaded " + students.size() + 
                             " students from " + filename);
            return students;
        } catch (FileNotFoundException e) {
            System.err.println("✗ File not found: " + filename);
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✗ Error loading students: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
   
    public boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
    

    public boolean deleteFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
    

    public Student findStudentByRollNo(List<Student> students, int rollno) {
        for (Student student : students) {
            if (student.getRollno() == rollno) {
                return student;
            }
        }
        return null;
    }
    

    public List<Student> findStudentsByCourse(List<Student> students, String course) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse().equalsIgnoreCase(course)) {
                result.add(student);
            }
        }
        return result;
    }
    

    public List<Student> findStudentsByAttendanceThreshold(List<Student> students, 
                                                           double threshold) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAttendance_percentage() < threshold) {
                result.add(student);
            }
        }
        return result;
    }
}
