package studentmanagement;

public class Student extends Person{
    private final int studentID;
    
    // constructor
    public Student(String name, int IDNo) {
        super(name);
        this.studentID = IDNo;
    }
    
    // getter
    public int getStudentID() {
        return this.studentID;
    }
    
    public void giveDetails() {
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("Name:\t" + this.getName() + "\nID:\t" + this.studentID);
        System.out.println(divider);
    }
}
