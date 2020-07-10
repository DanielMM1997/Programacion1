package ExamenOrd18_19;

public class Course {

    // Atributos
    private String name;
    private int id;
    
    //Constructor
    public Course(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
}