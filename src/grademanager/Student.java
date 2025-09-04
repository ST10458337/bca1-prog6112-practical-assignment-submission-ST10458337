/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grademanager;
/**
 *
 * @author lab_services_student
 */
public class Student extends Person{ // (IIEVC School of Computer Science, 2020)
    // Declerations
    private String studentId;
    private String course;
    
    // Constructor using super()
    public Student(String name, int age, String studentId, String course) {
        super(name, age); // Call parent constructor
        this.studentId = studentId;
        this.course = course;
    }
    
    
 
    // Override parent method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
    
    
    // Getters
    public String getStudentId() {
        return studentId;
    }
    
    public String getCourse() {
        return course;
    }
}
/*

Reference List:

IIEVC School of Computer Scienc, 2020. PROG6112 LU2 Inheritance 1. [video online] Available at: <https://www.youtube.com/playlist?list=PL480DYS-b_kfT7Gm7pZvU2By9-TcKD4-w> [Accessed 3 September 2025].

*/
