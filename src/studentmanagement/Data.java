package studentmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    // Departments
    public static List<Department> departments = Arrays.asList(
        new Department(1, "Computing"),
        new Department(2, "Mathematics"),
        new Department(3, "Language")
    );
    
    // Professors
    public static final Professor professor_1 = new Professor("Michael Owens", 5647, 1);
    public static final Professor professor_2 = new Professor("Peter David", 8675, 2);
    public static final Professor professor_3 = new Professor("Chris Adam", 5647, 3);
    
    public static List<Professor> professors = Arrays.asList(
        professor_1,
        professor_2,
        professor_3
    );
    
    // Courses
    public static final List<Course> all_courses = new ArrayList<>(Arrays.asList(
        new Course(3010, "OOP", 1, professor_1),
        new Course(2005, "Discrete Math", 2, professor_2),
        new Course(1058, "DSA", 1, professor_1),
        new Course(1020, "Composition", 3, professor_3),
        new Course(2080, "Requirements Engineering", 1),
        new Course(2030, "Spanish", 3),
        new Course(1070, "Calculus", 2),
        new Course(1010, "Intro. to programming", 1)
    ));
}
