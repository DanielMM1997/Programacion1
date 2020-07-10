package ExamenOrd18_19;
import java.util.*;

public class EnrolledStudents {

    // Atributos
    private List<Student> students;
    
    // Constructor
    public EnrolledStudents() {
        students = new ArrayList<>();
    }
    
    public boolean addStudent(Student student) {
        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).getId() == student.getId()) {
                return false;
            }
        }
        students.add(student);
        return true;
    }
    
    public boolean removeStudent(int id) {
        for (int i  = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Student getStudent(int id) {
        for (Student stu : students) {
            if (stu.getId() == id) {
                return stu;
            }
        }
        return null;
    }
    
    public List<Student> getStudentsByCourse(int id) {
        List<Student> courses = new ArrayList<>();
        for (Student stu : students) {
            for (Course course : stu.getEnrolledCourses()) {
                if (course.getId() == id) {
                    courses.add(stu);
                }
            }
        }
        Collections.sort(courses, new OrdenByName());
        return  courses;
    }
    
    public List<Student> getStudentsOrderByName() {
        Collections.sort(students, new OrdenByName());
        return students;
    }
    
    public List<Student> getStudentsOrderById() {
        Collections.sort(students, new OrdenById());
        return students;
    }
    
    private class OrdenByName implements Comparator<Student> {
        @Override
        public int compare(Student stu1, Student stu2) {
            if (stu1.getName().compareTo(stu2.getName()) > 0) {
                return 1;
            } else if (stu1.getName().compareTo(stu2.getName()) < 0) {
                return -1;
            } else if (stu1.getId() - stu2.getId() > 0) {
                return 1;
            } else if (stu1.getId() - stu2.getId() < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    private class OrdenById implements Comparator<Student> {
        @Override
        public int compare(Student stu1, Student stu2) {
            if (stu1.getId() - stu2.getId() > 0) {
                return 1;
            } else if (stu1.getId() - stu2.getId() < 0) {
                return -1;
            } else if (stu1.getName().compareTo(stu2.getName()) > 0) {
                return 1;
            } else if (stu1.getName().compareTo(stu2.getName()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}