package studentmanagement;

import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userType = 0;
        while (userType < 1 || userType > 4) {
            System.out.print("1. a student \n2. a professor \n3. an admin \n4. in finance \nPick a number. You are: ");
            if (scanner.hasNextInt()) {
                userType = scanner.nextInt();
            } else {
                System.out.println("\nChoose a number\n");
            }
            scanner.nextLine();
        }
        System.out.println();
        if (userType == 1) {
            Student newStudent = Utils.createStudent(scanner);
            Utils.enrollCourses(newStudent, scanner);
            newStudent.giveDetails();
        } else if (userType == 2) {
            Professor newProfessor = Utils.professorRegistration(scanner);
            newProfessor.giveDetails();
            Utils.pickCourse(newProfessor, scanner);
        } else if (userType == 3) {
            Admin newAdmin = Utils.createAdmin(scanner);
            newAdmin.giveDetails();
            Utils.addCourses(newAdmin, scanner);
        } else {
            Finance newFinanceOfficer = Utils.createFinanceOfficer(scanner);
            newFinanceOfficer.giveDetails();
        }
    }
    
}
