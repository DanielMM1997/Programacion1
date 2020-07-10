package PracticarTest;

import conjuntoenteros.*;
import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;

public class ConjuntoTest {
    private ConjuntoDeEnteros c0, c01, c1, c2, c3, c4, c5, c6, c7, c8, 
                                c9, c10, c11, c12, c13, c14, c15, c16;
    
    @Before
    public void inicializa() {
        int[] v01 = {};
        int[] v1 = {0};   
        int[] v2 = {1, -2};
        int[] v3 = {-2, -4, -6};
        int[] v4 = {1, 3, -3, 4};
        int[] v5 = {0, -2, -4, -6, -8};
        int[] v6 = {0, 1, 2, -6, 6, 8};
        int[] v7 = {0, 7, 1, 2, 4, -5, -6};
        int[] v8 = {8, 7, 6, 5, 4, 3, 2, 1}; 
        int[] v9 = {1, -2, 3, -4, 5, -6, 7, -8, 9};
        int[] v10 = {7, -10, 123, -123, 99, -7, 1, 0, -9, 10};
        
        c0 = new ConjuntoDeEnteros();
        c1 = new ConjuntoDeEnteros(v1);    
        c2 = new ConjuntoDeEnteros(v2);    
        c3 = new ConjuntoDeEnteros(v3);    
        c4 = new ConjuntoDeEnteros(v4);    
        c5 = new ConjuntoDeEnteros(v5);    
        c6 = new ConjuntoDeEnteros(v6);
        c7 = new ConjuntoDeEnteros(v7);
        c8 = new ConjuntoDeEnteros(v8);
        c9 = new ConjuntoDeEnteros(v9);
        c10 = new ConjuntoDeEnteros(v10);
        c01 = new ConjuntoDeEnteros(v01);
    }
    
    @Test
    public void probarConstructor() {
        int[] v11 = {-2, -1, 0, 1, 2}; 
        int[] v12 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
        int[] v13 = {};
        c11 = new ConjuntoDeEnteros(v11); 
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        
        assertEquals("El constructor ha fallado 1", 0, c0.cardinal());
        assertTrue("El constructor ha fallado 2", c0.estáVacío());
        assertEquals("El constructor ha fallado 3", 6, c6.cardinal());
        assertFalse("El constructor ha fallado 4", c6.estáVacío());
        assertEquals("El constructor ha fallado 5", 5, c11.cardinal());
        assertFalse("El constructor ha fallado 6", c11.estáVacío());
        assertEquals("El constructor ha fallado 7", 7, c12.cardinal());
        assertFalse("El constructor ha fallado 8", c12.estáVacío());
        assertEquals("El constructor ha fallado 9", 0, c13.cardinal());
        assertTrue("El constructor ha fallado 10", c13.estáVacío());
    }
    
    @Test
    public void probarMetodoCardinal() {
        assertEquals("Falla el metodo cardinal de c0", 0, c0.cardinal());
        assertEquals("Falla el metodo cardinal de c1", 1, c1.cardinal());
        assertEquals("Falla el metodo cardinal de c2", 2, c2.cardinal());
        assertEquals("Falla el metodo cardinal de c3", 3, c3.cardinal());
        assertEquals("Falla el metodo cardinal de c6", 6, c6.cardinal());
        assertEquals("Falla el metodo cardinal de c7", 7, c7.cardinal());
        assertEquals("Falla el metodo cardinal de c9", 9, c9.cardinal());
        assertEquals("Falla el metodo cardinal de c10", 10, c10.cardinal());
    }
    
    @Test
    public void probarMetodoEstáVacío() {
        assertTrue("C0 si esta vacio", c0.estáVacío());
        assertTrue("C01 si esta vacio", c01.estáVacío());
        assertFalse("C1 no esta vacio", c1.estáVacío());
        assertFalse("C2 no esta vacio", c2.estáVacío());
        assertFalse("C3 no esta vacio", c3.estáVacío());
        assertFalse("C5 no esta vacio", c5.estáVacío());
        assertFalse("C6 no esta vacio", c6.estáVacío());
        assertFalse("C9 no esta vacio", c9.estáVacío());
        assertFalse("C10 no esta vacio", c10.estáVacío());
    }
    
    @Test
    public void probarMetodoAñade() {
        c01.añade(10);
        c1.añade(1);
        c3.añade(5);
        c6.añade(2);
        int[] v11 = {0, 1};    
        int[] v12 = {5, -2, -4, -6};
        int[] v13 = {0, 1, 2, -6, 6, 8};
        int[] v14 = {10};
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        
        assertTrue("Falla cuando añade 10 a un conjunto vacio", c01.equals(c14));
        assertTrue("Falla cuando añade 1 a c1", c11.equals(c1));
        assertTrue("Falla cuando añade 1 a c1", c11.contenido(c1));
        assertTrue("Falla cuando añade 5 a c3", c12.equals(c3));
        assertTrue("Falla cuando añade 5 a c3", c12.equals(c3));
        assertTrue("Falla cuando añade 2 a c6", c13.equals(c6));
        assertTrue("Falla cuando añade 2 a c6", c13.contenido(c6));
        assertTrue("Falla cuando añade 0 a c9", c9.añade(0));
        assertFalse("Falla si se añade un elemento ya contenido", c10.añade(0));
        assertFalse("Falla si se añade a un conjunto lleno", c10.añade(15));
    }
    
    @Test
    public void probarMetodoUnion() {
        int[] v11 = {0, -2, -4, -6, -8};                          //union de c0 con c5
        int[] v12 = {0, 1, 2, -6, 6, 8};                          //union de c1 con c6
        int[] v13 = {1, 3, -3, 4};                                //union de c4 con c5
        int[] v14 = {0, 7, 1, 2, 4, -6, -5, -6, -2};              //union de c2 con c7
        int[] v15 = {1, -2, 3, -4, 5, -6, 7, -8, 9, 0};           //union de c1 con c9
        int[] v16 = {-2 , -4, -6, 7, -10, 123, -123, 99, -7, 1};  //union de c3 con c10
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        c15 = new ConjuntoDeEnteros(v15);
        c16 = new ConjuntoDeEnteros(v16);
        
        assertTrue("Falla la union de c0 con c5", c11.equals(c0.unión(c5)));
        assertTrue("Falla la union de c1 con c6", c12.equals(c1.unión(c6)));
        assertTrue("Falla la union de c6 con c1", c12.equals(c6.unión(c1)));
        assertTrue("Falla la union de c4 con c4", c13.equals(c4.unión(c4)));
        assertTrue("Falla la union de c2 con c7", c14.equals(c2.unión(c7)));
        assertTrue("Falla la union de c1 con c9", c15.equals(c9.unión(c1)));
        assertTrue("Falla la union de c3 con c10", c16.equals(c3.unión(c10)));
        assertTrue("Falla la union de c10 con c3 (esta lleno)", c10.equals(c10.unión(c3)));
        assertTrue("Falla la union de c9 con c3 (ya esta contenido)", c9.equals(c9.unión(c3)));
    }
    
    @Test
    public void probarMetodoInterseccion() {
        int[] v11 = {};                     //interseccion de c01 con c9
        int[] v12 = {-2, -4, -6};           //interseccion de c3 con c5
        int[] v13 = {0};                    //interseccion de c1 con c7
        int[] v14 = {0, 1, 2, -6};         //interseccion de c6 con c7
        int[] v15 = {1, 3, 5, 7};           //interseccion de c9 con c8
        int[] v16 = {7, 1};                 //interseccion con c10 con c8
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        c15 = new ConjuntoDeEnteros(v15);
        c16 = new ConjuntoDeEnteros(v16);
        
        assertTrue("Falla la interseccion de c01 con c9", c11.equals(c01.intersección(c9)));
        assertTrue("Falla la interseccion de c3 con c5",  c12.equals(c3.intersección(c5)));
        assertTrue("Falla la interseccion de c1 con c8",  c13.equals(c1.intersección(c7)));
        assertTrue("Falla la interseccion de c8 con c1",  c13.equals(c7.intersección(c1)));
        assertTrue("Falla la interseccion de c8 con c1",   c5.equals(c5.intersección(c5)));
        //assertTrue("Falla la interseccion de c6 con c7",  c14.equals(c6.intersección(c7)));
        assertTrue("Falla la interseccion de c9 con c8",  c15.equals(c9.intersección(c8)));
        assertTrue("Falla la interseccion de c10 con c8", c16.equals(c10.intersección(c8)));
    }
    
    @Test
    public void probarMetodoDiferencia() {
        int[] v11 = {};                                         //diferencia de c0 con c10
        int[] v12 = {7, -10, 123, -123, 99, -7, 1, 0, -9, 10};  //diferencia de c10 con c0
        int[] v13 = {0};                                        //diferencia de c1 con c4
        int[] v14 = {-2, -4, -8};                               //diferencia de c5 con c7
        int[] v15 = {1, 3, 5, 7, -8, 9};                        // diferencia de c9 con c3
        int[] v16 = {-10, 123, -123, 99, -7, -9, 10, 7};        //diferencia de c10 con c6
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        c15 = new ConjuntoDeEnteros(v15);
        c16 = new ConjuntoDeEnteros(v16);
        
        assertTrue("Falla la diferencia de c0 con c10", c11.equals(c0.diferencia(c10)));
        assertTrue("Falla la diferencia de c10 con c0", c12.equals(c10.diferencia(c0)));
        assertTrue("Falla la diferencia de c1 con c4", c13.equals(c1.diferencia(c4)));
        //assertTrue("Falla la diferencia de c8 con c8", c0.equals(c8.diferencia(c8)));
        assertTrue("Falla la diferencia de c5 con c7", c14.equals(c5.diferencia(c7)));
        assertTrue("Falla la diferencia de c9 con c3", c15.equals(c9.diferencia(c3)));
        assertTrue("Falla la diferencia de c10 con c6", c16.equals(c10.diferencia(c6)));
    }
    
    @Test
    public void probarMetodoPertenece() {
        assertFalse("1 No pertenece al c0 (conjunto vacio)", c0.pertenece(1));
        assertTrue("0 Si pertenece al c1", c1.pertenece(0));
        assertTrue("-4 Si pertenece al c3", c3.pertenece(-4));
        assertFalse("-4 N0 pertenece al c4", c4.pertenece(-4));
        assertTrue("8 Si pertenece al c6", c6.pertenece(8));
        assertFalse("3 No pertenece al c7", c7.pertenece(3));
        assertFalse("0 No pertenece al c01 (conjunto vacio)", c01.pertenece(0));
        assertTrue("-6 Si pertenece al c9", c9.pertenece(-6));
        assertTrue("123 Si pertenece al c10", c10.pertenece(123));
    }
    
    @Test
    public void probarMetodoContenido() {
        int[] v11 = {0, 1, 2, 3, 4, 5, 6};
        int[] v12 = {0, 2, 4, 6};
        int[] v13 = {1, 3, 5};
        int[] v14 = {0, 0, 2, 1, 0, -6, 6, 10, 8, 11, 9, 2, 1};
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        
        assertTrue("c0 si esta contenido en c11", c11.contenido(c0));
        assertFalse("c11 no esta contenido en c0", c0.contenido(c11));
        assertTrue("c1 si esta contenido en c12", c12.contenido(c1));
        assertFalse("c12 no esta contenido en c1", c1.contenido(c12));
        assertTrue("c12 si esta contenido en c11", c11.contenido(c12));
        assertFalse("c11 no esta contenido en c12", c12.contenido(c11));
        assertTrue("c13 si esta contenido en c11", c11.contenido(c13));
        assertFalse("c13 no esta contenido en c12", c12.contenido(c13));
        assertFalse("c11 no esta contenido en c14", c14.contenido(c11));
        assertTrue("c13 si esta contenido en c13", c13.contenido(c13));
        assertTrue("c2 si esta contenido en c9", c9.contenido(c2));
        assertFalse("c5 no esta contenido en c10", c10.contenido(c5));
        assertFalse("c3 no esta contenido en c11", c11.contenido(c3));
        assertTrue("c6 si esta contenido en c14", c14.contenido(c6));
    }
    
    @Test
    public void probarMetodoEquals() {
        int[] v11 = {0, 1, 2, 3, 4, 5, 6};
        int[] v12 = {6, 5, 4, 3, 2, 1, 0};
        int[] v13 = {1, 3, 5, 0, 6, 2, 4};
        int[] v14 = {1, 2, 3, 4, 5, 6};
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        
        assertTrue("c11 tiene que ser igual a c12", c11.equals(c12));
        assertTrue("c11 tiene que ser igual a c13", c11.equals(c13));
        assertTrue("c13 tiene que ser igual a c11", c13.equals(c11));
        assertTrue("c13 tiene que ser igual a c13", c13.equals(c13));
        assertFalse("c11 no debe ser igual a c14", c11.equals(c14));
        assertFalse("c14 no debe ser igual a c11", c14.equals(c11));
        assertFalse("c13 no debe ser igual a c14", c13.equals(c14));
        assertFalse("c9 no debe ser igual a c110", c9.equals(c10));
    }
    
    @Test
    public void probarMetodoElementos() {
        int[] v11 = c0.elementos();
        int[] v12 = c1.elementos();
        int[] v13 = {0, -2, -4, -6, -8};
        int[] v14 = c5.elementos();
        int[] v15 = c9.elementos();
        int[] v16 = c10.elementos();
        c11 = new ConjuntoDeEnteros(v11);
        c12 = new ConjuntoDeEnteros(v12);
        c13 = new ConjuntoDeEnteros(v13);
        c14 = new ConjuntoDeEnteros(v14);
        c15 = new ConjuntoDeEnteros(v15);
        c16 = new ConjuntoDeEnteros(v16);
        
        assertTrue("c11 tiene que ser igual que c0", c0.equals(c11));
        assertTrue("c12 tiene que ser igual que c1", c1.equals(c12));
        assertTrue("c13 tiene que ser igual a c14", c14.equals(c13));
        assertTrue("c14 tiene que ser igual a c5", c14.equals(c5));
        assertTrue("c15 tiene que ser igual a c15", c15.equals(c15));
        assertTrue("c9 tiene que ser igual a c15", c9.equals(c15));
        assertTrue("c16 tiene que ser igual a c10", c16.equals(c10));
        assertFalse("c15 no debe ser igual a c14", c15.equals(c14));
        assertFalse("c16 no debe ser igual a c15", c16.equals(c15));
    }
}