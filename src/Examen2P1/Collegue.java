/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2P1;

public class Collegue {
    private static offeredCourses offeredCourses = new offeredCourses();
    private static EnrolledStudents enrolledStudents = new EnrolledStudents();
    
    private static void init(offeredCourses offeredCourses, EnrolledStudents enrolledStudents) {
        offeredCourses.addCourse(new Course(100, "Mathematic"));
        offeredCourses.addCourse(new Course(101, "Language"));
        offeredCourses.addCourse(new Course(102, "History"));
        offeredCourses.addCourse(new Course(103, "Geography"));
        offeredCourses.addCourse(new Course(104, "Physics"));
        offeredCourses.addCourse(new Course(108, "Biology"));
        offeredCourses.addCourse(new Course(110, "Chemistry"));
        offeredCourses.addCourse(new Course(111, "Earth Science"));
        Student s1 = new Student(4, "Fulano");
        s1.enrolledCourse(offeredCourses.getCourse(100));
        s1.enrolledCourse(offeredCourses.getCourse(101));
        enrolledStudents.addStudent(s1);
        Student s2 = new Student(2, "Mengano");
        s2.enrolledCourse(offeredCourses.getCourse(101));
        s2.enrolledCourse(offeredCourses.getCourse(103));
        enrolledStudents.addStudent(s2);
        enrolledStudents.addStudent(new Student(3, "Zutano"));
        enrolledStudents.addStudent(s2);
    }

    public static void main (String[] args) {
        init(offeredCourses, enrolledStudents);
        //JavaSwing interfaz = new JavaSwing();
        //interfaz.assing(enrolledStudents, offeredCourses);
        CollegueGUI colegio = new CollegueGUI();
        colegio.asignar(enrolledStudents, offeredCourses);
        colegio.showStudent(); 
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
