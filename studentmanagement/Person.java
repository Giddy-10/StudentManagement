package studentmanagement;

// abstract class
public abstract class Person {
    private final String name;
    
    // constructor
    public Person(String nameString){
        this.name = nameString;
    }
    
    // getter
    public String getName() {
        return this.name;
    }
    
    public void giveName(){
        System.out.println("Your name is: " + name);
    }
    
    public abstract void giveDetails();
}
