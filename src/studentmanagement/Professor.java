package studentmanagement;

public class Professor extends Staff {
    private int departmentID;
    
    // constructors
    public Professor(String name, int IDNo) {
        super(name, IDNo);
    }
    
    public Professor(String name, int IDNo, int depIDNo) {
        super(name, IDNo);
        this.departmentID = depIDNo;
    }
    
    // setter
    public void setDepartment(int depIDNo) {
        this.departmentID = depIDNo;
    }
    
    // getter
    public int getDepartmentId() {
        return this.departmentID;
    }
    
    @Override
    public void giveDetails() {
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("Name:\t" + this.getName() + "\nID:\t" + this.getStaffID() + "\nDepartment:\t" + this.departmentID);
        System.out.println(divider + "\n");
    }
    
    public void printData() {
        System.out.println(this.getStaffID() + ":\t" + this.getName());
    }
}
