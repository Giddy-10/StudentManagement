package studentmanagement;

public class Finance extends Staff {
    public Finance(String name, int IDNo) {
        super(name, IDNo);
    }
    
    @Override
    public void giveDetails() {
        String divider = "-----------------------------------";
        System.out.println(divider);
        System.out.println("Finance Officer\n");
        System.out.println("Name:\t" + this.getName() + "\nID:\t" + this.getStaffID());
        System.out.println(divider + "\n");
    }
}
