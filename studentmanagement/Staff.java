package studentmanagement;

// inheritance
public class Staff extends Person {
    private final int staffID;
    
    // constructor
    public Staff(String name, int IDNo) {
        super(name);
        this.staffID = IDNo;
    }
    
    // getter
    public int getStaffID() {
        return this.staffID;
    }
    
    @Override
    public void giveDetails() {
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("Name:\t" + this.getName() + "\nID:\t" + this.staffID);
        System.out.println(divider);
    }
}
