package studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utils {
    public static Course findCourseById(List<Course> list, int id) {
        return list.stream()
                   .filter(c -> c.getId() == id)
                   .findFirst()
                   .orElse(null);
    }
    
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
    
    public static void enrollCourses(Student student, Scanner scanner) {
        List<Course> availableCourses = new ArrayList<>(Data.all_courses);
        final int number_of_courses = 3;
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("Student: " + student.getName());
        System.out.println("Courses to pick: " + number_of_courses);
        
        for (int i=0; i < number_of_courses; i++) {
            System.out.println("Available Courses:");
            Course pickedCourse = null;
            while (pickedCourse == null) {
                availableCourses.forEach(c -> 
                    System.out.println("  ID: " + c.getId() + ", Name: " + c.getName())
                );
                System.out.print("\nID: ");
                int courseID = scanner.nextInt();
                scanner.nextLine();
                Course selection = findCourseById(availableCourses, courseID);
                if (selection != null) {
                    pickedCourse = selection;
                } else {
                    System.out.println("Invalid ID");
                }
            }
            
            student.enrollCourse(pickedCourse);
            availableCourses.remove(pickedCourse);
            System.out.println("Enrolled in: " + pickedCourse.getName() + "\n");
        }
        
        System.out.println("Course selection complete\n");
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
    
    public static void pickCourse(Professor professor, Scanner scanner) {
        int departmentID = professor.getDepartmentId();
        List<Course> availableCourses = Data.all_courses.stream()
            .filter(course -> course.getProfessor() == null)
            .filter(course -> course.getDepartmentId() == departmentID)
            .collect(Collectors.toList());
        
        if (availableCourses.isEmpty()) {
            System.out.println("No unassigned courses available in your department");
        }
        
        System.out.println("Available Courses in your department:");
        for (Course c : availableCourses) {
            System.out.println("  ID: " + c.getId() + ", Name: " + c.getName());
        }
        Course selectedCourse = null;
        while (selectedCourse == null) {
            System.out.print("\nID: ");
            int courseID = scanner.nextInt();
            scanner.nextLine();
            
            try {
                selectedCourse = findCourseById(availableCourses, courseID);

                if (selectedCourse == null) {
                    System.out.println("Error: Course ID not found in the list of available courses. Try again.");
                }
            } catch (Error e) {
                System.out.println("Invalid input");
            }
        }

        selectedCourse.setProfessor(professor);

        System.out.println("\nCourse assigned");
        System.out.println("Course: " + selectedCourse.getName());
    }
    
    private static boolean isIDPresent(List<Course> courses, int id) {
        return courses.stream().anyMatch(c -> c.getId() == id);
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
    
    public static void addCourses(Admin admin, Scanner scanner) {
        List<Course> allCourses = Data.all_courses;
        final int max_courses = 3;
        int coursesAdded = 0;
        
        while (coursesAdded < max_courses) {
            if (coursesAdded > 0) {
                System.out.print("Add another course? (y/n): ");
                String choice = scanner.nextLine().trim().toLowerCase();
                if (!choice.equals("y")) {
                    break;
                }
            }
            
            System.out.println("\nAdd course");
            int newID = 0;
            while (newID == 0) {
                System.out.print("Enter course ID (1000-9999): ");
                int potentialID = scanner.nextInt();
                scanner.nextLine();
                if (potentialID < 1000 || potentialID > 9999) {
                    System.out.println("Enter valid ID\n");
                } else if(isIDPresent(allCourses, potentialID)) {
                    System.out.println("Id " + potentialID + " is already taken");
                } else {
                    newID = potentialID;
                }
            }
            String newName;
            while (true) {
                System.out.print("Course name: ");
                newName = scanner.nextLine().trim();
                if (!newName.isEmpty()) break;
            }
            int depID = 0;
            while (depID == 0) {
                for (Department d: Data.departments) {
                    System.out.println("ID: " + d.getId() + " Name: " + d.getName());
                }
                depID = scanner.nextInt();
                scanner.nextLine();
            }
            
            Course newCourse = new Course(newID, newName, depID);
            allCourses.add(newCourse);
            coursesAdded++;
            
            System.out.println("Added: " + newCourse.getName() + " Code: " + newCourse.getId() + "\n");
        }
        
        System.out.println("Added " + coursesAdded + " course(s)\n");
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
