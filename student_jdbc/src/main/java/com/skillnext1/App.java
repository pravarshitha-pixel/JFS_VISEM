package com.skillnext1;


import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n***** STUDENT MANAGEMENT *****");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student (by ID)");
            System.out.println("3. Delete Student (by ID)");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

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
                        dao.addStudent(new Student(name, sem, dept));
                        System.out.println("Student Added Successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Student ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String uname = sc.nextLine();
                        System.out.print("Enter New Semester: ");
                        int usem = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Department: ");
                        String udept = sc.nextLine();
                        dao.updateStudent(uid, uname, usem, udept);
                        System.out.println("Student Updated Successfully!");
                        break;

                    case 3:
                        System.out.print("Enter Student ID to Delete: ");
                        int did = sc.nextInt();
                        dao.deleteStudent(did);
                        System.out.println("Student Deleted Successfully!");
                        break;

                    case 4:
                        List<Student> list = dao.getAllStudents();
                        System.out.println("\n--- Student Records ---");
                        for (Student s : list) {
                            System.out.println(s);
                        }
                        break;

                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Option!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
