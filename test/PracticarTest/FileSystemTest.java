package PracticarTest;
import ExamenP1.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FileSystemTest {
    
    private Element e1, e2;
    
    @Test
    public void probarElement(){
        assertEquals("la prueba falla", e1, e2);
    }
    
    public static void main(String[] args){
         org.junit.runner.JUnitCore.main("PracticarTest.AlumnosTest");        
    } 
}
