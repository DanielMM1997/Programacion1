package componentes;
import java.util.*;
public class UsaDocumentos {
    
    public static void main (String[] args) {
        long segundosDía = 60 * 60 * 24;
        ComponenteCompuesto d, p;
        Date hoy = new Date();
        p = new ComponenteCompuesto();
        ComponenteTexto t = new ComponenteTexto("t");
        if (t.toString() == t.copia().toString()) {
            System.out.println("Son iguales");
        }
        p.añade(new ComponenteTexto("Ristra "));
        p.añade(new ComponenteNumero(1));
        p.añade(new ComponenteTexto("\n"));
        p.añade(new ComponenteTexto("Fecha de hoy "));
        p.añade(new ComponenteFecha(hoy));
        p.añade(new ComponenteTexto("\n"));
        p.añade(new ComponenteTexto("Fecha de ayer "));
        p.añade(new ComponenteFecha(new Date(hoy.getTime() - segundosDía*1000)));
        p.añade(new ComponenteTexto("\n"));
        p.añade(new ComponenteTexto("Fecha de hace 30 días ("));
        p.añade(new ComponenteNumero(86400 * 30));
        p.añade(new ComponenteTexto(" seg) "));
        p.añade(new ComponenteFecha( new Date(hoy.getTime() - (segundosDía * 30*1000))));
        p.añade(new ComponenteTexto("\n"));
        d = new ComponenteCompuesto();
        d.añade(new ComponenteTexto("Componente de prueba"));
        d.añade(new ComponenteTexto("\n"));
        d.añade(p);
        d.añade(new ComponenteTexto("Fin componente de prueba"));
        System.out.println(d);
        System.out.println("Número de caracteres " + d.nCaracteres());
        System.out.println("Número de palabras " + d.nPalabras());
        d.modifica(0, new ComponenteTexto("Inicio modificado"));
        System.out.println(d);
        System.out.println("Número de caracteres " + d.nCaracteres());
        System.out.println("Número de palabras " + d.nPalabras());
        
        //org.junit.runner.JUnitCore.main("ComponentesTest");
    }
}