package studentmanagement;

import java.util.Optional;
import java.util.Scanner;

public class UtilsRegistration {
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
    
    public static Professor professorRegistration(Scanner scanner) {
        for (Professor p: Data.professors) {
            p.printData();
        }
        String choice = "";
        while (!(choice.equals("y") || choice.equals("n"))) {
            System.out.print("Are you one of the hard-coded professors? (y/n): ");
            choice = scanner.nextLine().trim().toLowerCase();
            System.out.println();
        }
        if (choice.equals("y")) {
            for (Professor p: Data.professors) {
                p.printData();
            }
            System.out.print("Choose ID: ");
            int staffID = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            Optional<Professor> foundProf = Data.professors.stream()
                .filter(p -> p.getStaffID() == staffID)
                .findFirst();
            if (foundProf.isPresent()) {
                System.out.println("Login successful! Welcome, " + foundProf.get().getName() + ".\n");
                return foundProf.get();
            } else {
                System.out.println("Error: Professor ID not found.\n");
                return null;
            }
        } else {
            Professor newProfessor = createProfessor(scanner);
            System.out.println("Registered as " + newProfessor.getName());
            return newProfessor;
        }
    }
    
    public static Professor createProfessor(Scanner scanner) {
        System.out.print("Name: ");
        String professorName = scanner.nextLine();
        System.out.print("Staff ID: ");
        int staffID = scanner.nextInt();
        scanner.nextLine();
        int departmentID = Utils.pickDepartmentId(scanner);
        System.out.println();
        Professor professor = new Professor(professorName, staffID, departmentID);
        return professor;
    }
    
    public static Admin createAdmin(Scanner scanner) {
        System.out.print("Name: ");
        String adminName = scanner.nextLine();
        System.out.print("Staff ID: ");
        int staffID = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        Admin newAdmin = new Admin(adminName, staffID);
        return newAdmin;
    }
    
    public static Finance createFinanceOfficer(Scanner scanner) {
        System.out.print("Name: ");
        String financeName = scanner.nextLine();
        System.out.print("Staff ID: ");
        int staffID = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        Finance newFinanceOfficer = new Finance(financeName, staffID);
        return newFinanceOfficer;
    }
}
