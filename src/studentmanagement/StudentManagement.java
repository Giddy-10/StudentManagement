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
            newStudent.giveDetails();
        } else if (userType == 2) {
            System.out.println("You are a professor");
        } else if (userType == 3) {
            System.out.println("You are an admin");
        } else {
            System.out.println("You work in finance");
        }
    }
    
}
