package ExamenOrd18_19;

import java.util.*;

public class Student {

    //Atributos
    private String name;
    private int id;
    private List<Course> subjects;
    
    // Constructor
    public Student(String name, int id){
        this.name = name;
        this.id = id;
        this.subjects = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean enrollCourse(Course subject) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getName().equals(subject.getName())) {
                return false;
            }
        }
        subjects.add(subject);
        return true;
    }
    
    public boolean unenrollCourse(int id) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId() == id) {
                subjects.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Collection<Course> getEnrolledCourses() {
        return subjects;
    }
    
    @Override
    public String toString() {
        String res = getId() + "-" + getName() + "[";
        for (int i = 0; i < subjects.size(); i++) {
            res += "(" + subjects.get(i).getId() + ")" + subjects.get(i).getName() + ","; 
        }
        return res.substring(0, res.length()-1) + "]";
    }
}