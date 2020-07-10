package componentes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ComponenteFecha extends Componente implements Cloneable{
    
    private Date fecha;
    
    public ComponenteFecha (Date fecha) {
        this.fecha = fecha;
    } 
    
    @Override
    public String toString() {
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(fecha);
        int dia = calendario.get(Calendar.DATE);
        int mes = calendario.get(Calendar.MONTH)+1;
        int año = calendario.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + año;
    }
    
    @Override
    public Componente copia() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    @Override
    public ComponenteFecha clone() throws CloneNotSupportedException {
        ComponenteFecha copia = (ComponenteFecha) super.clone();
        copia.fecha = (Date) fecha.clone();
        return copia;
    }
}