package studentmanagement;

import java.util.Scanner;

public class Utils {
    public static Student createStudent(Scanner scanner) {
        System.out.print("Name: ");
        String studentName = scanner.nextLine();
        System.out.print("ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        Student student = new Student(studentName, studentID);
        return student;
    }
    
    public static Professor createProfessor(Scanner scanner) {
        System.out.print("Name: ");
        String professorName = scanner.nextLine();
        System.out.print("Staff ID: ");
        int staffID = scanner.nextInt();
        scanner.nextLine();
        int departmentID = pickDepartmentId(scanner);
        System.out.println();
        Professor professor = new Professor(professorName, staffID, departmentID);
        return professor;
    }
    
    public static int pickDepartmentId(Scanner scanner) {
        for (Department d: Data.departments) {
            d.printData();
        }
        System.out.print("Pick a department ID: ");
        int departmentID = scanner.nextInt();
        scanner.nextLine();
        return departmentID;
    }
}
