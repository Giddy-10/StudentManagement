package studentmanagement;

public class Course {
    private final int id;
    private final String name;
    private final int departmentID;
    private Professor professor;
    private double fee;

    // constructors (polymorphism - overloading)
    public Course(int id, String name, int depIDNo) {
        this.id = id;
        this.name = name;
        this.departmentID = depIDNo;
    }
    
    public Course(int id, String name, int depIDNo, Professor professor) {
        this.id = id;
        this.name = name;
        this.departmentID = depIDNo;
        this.professor = professor;
    }
    
    // setters
    public void setProfessor (Professor professor) {
        this.professor = professor;
    }
    
    public void setFee(double fee) {
        this.fee = fee;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public int getDepartmentId() {
        return this.departmentID;
    }

    public Professor getProfessor() {
        return this.professor;
    }
    
    public double getFee() {
        return this.fee;
    }
}
