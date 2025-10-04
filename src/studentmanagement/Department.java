package studentmanagement;

public class Department {
    private final int id;
    private final String name;

    // Constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public void printData() {
        System.out.print(this.id + ":\t" + this.name);
    }
}
