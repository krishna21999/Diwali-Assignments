// File: beans/Student.java
package com.demo.beans;

import java.io.Serializable;

import com.demo.Exception.InsufficientAttendanceException;

public class Student implements Serializable, Comparable<Student> {
    private static final long serialVersionUID = 1L;
    
    private int rollno;
    private String sname;
    private String course;
    private double attendance_percentage;
    private double score;
    
    // Default constructor
    public Student() {
        this.rollno = 0;
        this.sname = "";
        this.course = "";
        this.attendance_percentage = 0.0;
        this.score = 0.0;
    }
    
    // Parameterized constructor
    public Student(int rollno, String sname, String course, 
                   double attendance_percentage, double score) 
                   throws InsufficientAttendanceException {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        
        // Check attendance percentage
        if (attendance_percentage < 60) {
            throw new InsufficientAttendanceException(
                "Insufficient Attendance for " + sname + 
                " (Roll No: " + rollno + "). Attendance: " + 
                attendance_percentage + "% (Minimum required: 60%)"
            );
        }
        
        this.attendance_percentage = attendance_percentage;
        this.score = score;
    }
    
    // Method to calculate grade based on score
    public String calculateGrade() {
        if (score >= 90) {
            return "A+";
        } else if (score >= 80) {
            return "A";
        } else if (score >= 70) {
            return "B+";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Getters
    public int getRollno() {
        return rollno;
    }
    
    public String getSname() {
        return sname;
    }
    
    public String getCourse() {
        return course;
    }
    
    public double getAttendance_percentage() {
        return attendance_percentage;
    }
    
    public double getScore() {
        return score;
    }
    
    // Setters
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public void setAttendance_percentage(double attendance_percentage) 
                                         throws InsufficientAttendanceException {
        if (attendance_percentage < 60) {
            throw new InsufficientAttendanceException(
                "Insufficient Attendance. Cannot set attendance below 60%"
            );
        }
        this.attendance_percentage = attendance_percentage;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    // CompareTo method for sorting by attendance in decreasing order
    @Override
    public int compareTo(Student other) {
        // Decreasing order: higher attendance comes first
        return Double.compare(other.attendance_percentage, this.attendance_percentage);
    }
    
    @Override
    public String toString() {
        return String.format(
            "Roll No: %-4d | Name: %-15s | Course: %-10s | Attendance: %6.2f%% | Score: %6.2f | Grade: %s",
            rollno, sname, course, attendance_percentage, score, calculateGrade()
        );
    }
}
