/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grademanager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class GradeManager {
    public static void main(String[] args) {
        
        GradeManager manager = new GradeManager();
        manager.runApplication();
    }
        // Array to store students
    private ArrayList<Student> students;
    private Scanner scanner;
    
    // Constructor
    public GradeManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
  
    
    // Main application loop
    public void runApplication() {
        System.out.println("=================================");
        System.out.println("  STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("=================================");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    viewStudentDetails();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the Grade Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    // Display menu options
    private void displayMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Add New Student");
        System.out.println("2. Add Grade to Student");
        System.out.println("3. View Student Details");
        System.out.println("4. View All Students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    // Get user input
    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
    
    // Method for adding new student
    private void addNewStudent() {
        System.out.println("\n--- ADD NEW STUDENT ---");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age! Student not added.");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        
        System.out.print("Enter course: ");
        String course = scanner.nextLine();
        
        // Create new student
        Student newStudent = new Student(name, age, studentId, course);
        students.add(newStudent);
        
        System.out.println("Student added successfully!");
    }
    
    
    // View individual student details
    private void viewStudentDetails() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.println("\n--- STUDENT DETAILS ---");
        student.displayInfo();
    }
    
    // View all students
    private void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n ALL STUDENTS ");
        // for loop
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students.get(i).displayInfo();
            System.out.println("-------------------------");
        }
    }
    
    // Generate class report
    private void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n CLASS REPORT ");
        System.out.println("Total Students: " + students.size());
       
        
        System.out.println("\nDetailed Student Performance:");
        System.out.println("-----------------------------");
        
        // Display student performance
        for (Student student : students) {
            System.out.printf("%-15s | ID: %-8s", 
                student.getName(), 
                student.getStudentId(),
        }
        System.out.println("-----------------------------");
    }
    
    // Helper method to find student by ID
    private Student findStudent(String studentId) {
        // Using enhanced for loop to search
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null; // Not found
    }
    
}
