/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grademanager;
import java.util.ArrayList;
/**
 *
 * @author lab_services_student
 */
public class Student extends Person{ // (IIEVC School of Computer Science, 2020)
    // Declerations
    private String studentId;
    private String course;
    private ArrayList<Double> grades = new ArrayList<>();
    
    // Constructor using super()
    public Student(String name, int age, String studentId, String course) {
        super(name, age); // Call parent constructor
        this.studentId = studentId;
        this.course = course;
        this.grades = new ArrayList<>();
    }
    
    public void addGrade(double grade) {
    if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Grade needs to be between 0 and 100");
        }
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    public String getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
    
     public int getGradeCount() {
        return grades.size();
    }
    
    
 
    // Override parent method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Number of grades: " + grades.size());
        System.out.println("Average: " + String.format("%.2f", getAverage()) + " (" + getLetterGrade() + ")");
    }
    
    
    // Getters
    public String getStudentId() {
        return studentId;
    }
    
    public String getCourse() {
        return course;
    }
    
    public ArrayList<Double> getGrades() {
        return new ArrayList<>(grades);
    }
}
/*

Reference List:

IIEVC School of Computer Scienc, 2020. PROG6112 LU2 Inheritance 1. [video online] Available at: <https://www.youtube.com/playlist?list=PL480DYS-b_kfT7Gm7pZvU2By9-TcKD4-w> [Accessed 3 September 2025].

*/
