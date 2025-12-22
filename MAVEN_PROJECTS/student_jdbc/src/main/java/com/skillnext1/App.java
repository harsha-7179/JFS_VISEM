package com.skillnext1;

import java.util.Scanner;
import java.util.List;


public class App {

    public static void main(String[] args) {
        System.out.println("🔥 TEST MESSAGE: THIS IS NEW APP.JAVA 🔥");

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();   // consume newline

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Semester: ");
                        int sem = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        Student newStudent = new Student(name, sem, dept);
                        dao.insert(newStudent);
                        System.out.println("✔ Student added successfully!");
                        break;

                    case 2:
                        List<Student> students = dao.getAllStudents();
                        System.out.println("\n---- Student Records ----");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        int upId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String upName = sc.nextLine();

                        System.out.print("New Sem: ");
                        int upSem = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Dept: ");
                        String upDept = sc.nextLine();

                        Student updatedStudent = new Student(upName, upSem, upDept);
                        updatedStudent.setId(upId);

                        dao.updateStudent(updatedStudent);
                        System.out.println("✔ Student updated successfully!");
                        break;

                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        int delId = sc.nextInt();
                        dao.deleteStudent(delId);
                        System.out.println("✔ Student deleted successfully!");
                        break;

                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("❌ Invalid choice! Try again.");
                }

            } catch (Exception e) {
                System.out.println("❌ ERROR: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
