package studentmanagement;

import java.util.ArrayList;
import java.util.List;

// inheritance
public class Student extends Person{
    private final int studentID;
    private final List<Course> enrolledCourses;
    
    // constructor
    public Student(String name, int IDNo) {
        super(name);
        this.studentID = IDNo;
        this.enrolledCourses = new ArrayList<>();
    }
    
    // getters
    public int getStudentID() {
        return this.studentID;
    }
    
    public List<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }
    
    // methods
    public void enrollCourse(Course course) {
        this.enrolledCourses.add(course);
    }
    
    @Override
    public void giveDetails() {
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("Name:\t" + this.getName() + "\nID:\t" + this.studentID);
        System.out.println("Enrolled Courses: " + this.enrolledCourses.size());
        this.enrolledCourses.forEach(c -> System.out.println("\t- " + c.getName()));
        System.out.println(divider + "\n");
    }
}
