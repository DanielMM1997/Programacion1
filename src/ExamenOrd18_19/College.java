package ExamenOrd18_19;

public class College {
    private static OfferedCourses offeredCourses = new OfferedCourses();
    private static EnrolledStudents enrolledStudents = new EnrolledStudents();
    
    private static void init(OfferedCourses offeredCourses, EnrolledStudents enrolledStudents) {
        offeredCourses.addCourse(new Course("Mathematic", 100));
        offeredCourses.addCourse(new Course("Language", 101));
        offeredCourses.addCourse(new Course("History", 102));
        offeredCourses.addCourse(new Course("Geography", 103));
        offeredCourses.addCourse(new Course("Physics", 104));
        offeredCourses.addCourse(new Course("Biology", 105));
        offeredCourses.addCourse(new Course("Chemistry", 106));
        offeredCourses.addCourse(new Course("Earth Sciencs", 107));
        Student s1 = new Student("Fulano", 4);
        s1.enrollCourse(offeredCourses.getCourse(100));
        s1.enrollCourse(offeredCourses.getCourse(101));
        enrolledStudents.addStudent(s1);
        Student s2 = new Student("Mengano", 2);
        s2.enrollCourse(offeredCourses.getCourse(101));
        s2.enrollCourse(offeredCourses.getCourse(103));
        enrolledStudents.addStudent(s2);
        enrolledStudents.addStudent(new Student("Zutano", 3));
        enrolledStudents.addStudent(s2);
    }

    public static void main(String[] args){
        init(offeredCourses, enrolledStudents);
        //JavaSwing interfaz = new JavaSwing();
        //interfaz.assing(enrolledStudents, offeredCourses);
        CollegeGUI colegio = new CollegeGUI();
        //colegio.showStudent(); 
        System.out.println(enrolledStudents.getStudent(4));
        System.out.println(enrolledStudents.getStudent(2));
        System.out.println(enrolledStudents.getStudentsOrderByName());
        System.out.println(enrolledStudents.getStudentsOrderById());
        System.out.println(enrolledStudents.getStudentsByCourse(100));
        System.out.println(enrolledStudents.getStudentsByCourse(101));
        System.out.println(enrolledStudents.getStudentsByCourse(103));
        System.out.println(enrolledStudents.getStudentsByCourse(1));
/* A continuaciÃ³n se muestra la salida esperada de la ejecuciÃ³n del main
4-Fulano[(100)Mathematic, (101)Language]
2-Mengano[(101)Language, (103)Geography]
[4-Fulano[(100)Mathematic, (101)Language], 2-Mengano[(101)Language, (103)Geography], 3-Zutano[]]
[2-Mengano[(101)Language, (103)Geography], 3-Zutano[], 4-Fulano[(100)Mathematic, (101)Language]]
[4-Fulano[(100)Mathematic, (101)Language]]
[4-Fulano[(100)Mathematic, (101)Language], 2-Mengano[(101)Language, (103)Geography]]
[2-Mengano[(101)Language, (103)Geography]]
[]
*/
    }
}