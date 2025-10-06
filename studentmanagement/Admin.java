package studentmanagement;

// inheritance
public class Admin extends Staff {
    // constructor
    public Admin(String name, int IDNo) {
        super(name, IDNo);
    }
    
    // methods
    // polymorphism (overriding)
    @Override
    public void giveDetails() {
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("ADMIN\n");
        System.out.println("Name:\t" + this.getName() + "\nID:\t" + this.getStaffID());
        System.out.println(divider + "\n");
    }
}
