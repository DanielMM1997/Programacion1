package ExamenP1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
/*
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class FileSystemTest {
    
    private Directory d1, d2, d3, d4, d5;
    private File f1, f2, f3, f4, f5, f6, f7;
    
    @Before
    public void fixture(){
        d1 = new Directory("Apuntes", null);
        d2 = new Directory("Algebra", d1);
        d3 = new Directory("Examenes", d2);
        d4 = new Directory("Programacion", d1);
    
        f1 = new File("MiHorario", 20, d1);
        f2 = new File("Resumen", 50, d2);
        f3 = new File("ExamenJunio", 10, d3);
        f4 = new File("ExamenEnero", 10, d3);
        f5 = new File("Interfaz", 20, d4);
        f6 = new File("Contenedores", 20, d4);
    }
    
    @Test
    public void TestGetParent(){
        assertEquals("Fallo en: ", "Apuntes", d4.getParent().getName());
        assertEquals("Fallo en: ", "Algebra", f2.getParent().getName());
        assertEquals("Fallo en: ", "Examenes", f4.getParent().getName());
        assertEquals("Fallo en: ", "Programacion", f6.getParent().getName());
    }
    
    @Test
    public void TestGetPath(){
        AssertEquals("Fallo en: ", "/Apuntes/Algebra/Resumen", f2.getPath());
        AssertEquals("Fallo en: ", "/Apuntes/MiHorario", f1.getPath());
        AssertEquals("Fallo en: ", "/Apuntes/Programacion", d4.getPath());
    }    
    
    @Test
    public void TestGetElements(){
        Element[] name = new Element[2];
        name.add(f3);
        name.add(f4);
        AssertEquals("Fallo en: ", name, d3.getElements());
    }
}*/
