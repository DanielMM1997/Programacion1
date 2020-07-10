package PracticarTest;

import Examen2P1.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AlumnosTest {
    Student a, b, c;
    Course mates, lengua, filosofia, artes;
    EnrolledStudents enroll;
    
    @Before
    public void setUp() {
        mates = new Course(1, "mates");
        lengua = new Course(2, "lengua");
        filosofia = new Course(3, "filosofia");
        artes = new Course(4, "artes");
        a = new Student(1, "Kevin");
        b = new Student(2, "Jesus");
        c = new Student(3, "Daniel");
    }

    @Test
    public void probarNombre() {
        assertEquals("Fallo en el nombre de ", "Kevin", a.getName());
        assertEquals("Fallo en el nombre de ", "Daniel", c.getName());
        assertEquals("Fallo en el nombre de ", "lengua", lengua.getName());
    }
    
    public static void main(String[] args){
         org.junit.runner.JUnitCore.main("PracticarTest.AlumnosTest");        
    } 
}
