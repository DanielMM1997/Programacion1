package ExamenOrd18_19;
import java.util.*;

public class OfferedCourses {

    // Atributos 
    private List<Course> courses;
    
    // Constructor
    public OfferedCourses() {
        courses = new ArrayList<>();
    }
    
    public boolean addCourse(Course course) {
        return courses.add(course);
    }
    
    public Course getCourse(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
}